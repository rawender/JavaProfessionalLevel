package DZ2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] iArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        String[] sArray = {" one ", " two ", " three ", " four ", " five ", " six ", " seven ", " eight ", " nine ", " zero "};

        arrayToArrayList(iArray);
        arrayToArrayList(dArray);
        arrayToArrayList(sArray);

        System.out.println(Arrays.toString(iArray));
        System.out.println(Arrays.toString(dArray));
        System.out.println(Arrays.toString(sArray));
    }

    private static <T> ArrayList arrayToArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }
}
