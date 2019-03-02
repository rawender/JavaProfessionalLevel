package DZ1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] iArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        String[] sArray = {" one ", " two ", " three ", " four ", " five ", " six ", " seven ", " eight ", " nine "};

        try {
            swapTwoElementsInArray(iArray, 0, 8);
            swapTwoElementsInArray(dArray, 1, 7);
            swapTwoElementsInArray(sArray, 2, 6);
        } catch (WrongPositionException e) {
            e.printStackTrace();
        }

        info(iArray);
        info(dArray);
        info(sArray);

    }

    private static void swapTwoElementsInArray(Object[] array, int firstNumInd, int secondNumInd) throws WrongPositionException{//
        if (firstNumInd < 0 || firstNumInd >= array.length || secondNumInd < 0 || secondNumInd >= array.length || firstNumInd == secondNumInd) {
            throw new WrongPositionException("Неправильно указан индекс элементов для замены");
        }

        Object temp = array[firstNumInd];
        array[firstNumInd] = array[secondNumInd];
        array[secondNumInd] = temp;
    }

    private static void info(Object[] array) {
        System.out.println(Arrays.toString(array));
    }
}
