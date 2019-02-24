package DZ2;

public class ArrAfterFour {
    public int[] methodArrAfterFour(int[] arr) throws RuntimeException {
        int[] result;
        int a = 0;
        int need = 4;
        boolean found = false;
        for (int i = arr.length - 1; i >= 0; i --) {
            if (arr[i] == need) {
                found = true;
                a = i;
                break;
            }
        }
        if(found) {
            result = new int[arr.length - a - 1];
            for (int i = a + 1; i < arr.length; i++) {
                result[i - a - 1] = arr[i];
            }
        } else {
            throw new RuntimeException("В массиве нет " + need);
        }
        return  result;
    }
}
