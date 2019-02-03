package DZ3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    String name;
    ArrayList<T> box;

    public Box(String name, T... fruits) {
        this.name = name;
        box = new ArrayList<T>(Arrays.asList(fruits));
    }

    public String getName() {
        return name;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            totalWeight = totalWeight + box.get(i).getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> boxWithSomething) {
        return Math.abs(getWeight() - boxWithSomething.getWeight()) < 0.0001f;
    }

    public void replaceFruitsToAnotherBox(Box<T> anotherBox) {
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }

    public void info() {
        System.out.println(name + ": фруктов в коробке - " + box.size());
    }
}
