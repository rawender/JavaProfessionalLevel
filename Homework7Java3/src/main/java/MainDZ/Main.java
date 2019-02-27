package MainDZ;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(ClassTestDZ.class);
    }

    private static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList <>();
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].isAnnotationPresent(Test.class)) {
                int prty = methods[i].getAnnotation(Test.class).priority();
                if(prty < 1 || prty > 10) throw  new RuntimeException("Нарушение условий приоритета");
                list.add(methods[i]);
            }
        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].isAnnotationPresent(BeforeSuite.class)) {
                if(list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("Исключение по BeforeSuite");
                list.add(0, methods[i]);
            }
            if(methods[i].isAnnotationPresent(AfterSuite.class)) {
                if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("Исключение по AfterSuite");
                list.add(methods[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).invoke(c);
        }
    }
}
