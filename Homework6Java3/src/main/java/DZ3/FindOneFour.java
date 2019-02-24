package DZ3;

public class FindOneFour {
    public boolean methodFindOneFour(int[] arr) {
        boolean result = true;
        int needA = 1;
        int needB = 4;
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == needA) {
                countA++;
            } else {
                if(arr[i] == needB) {
                    countB++;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result && countA > 0 && countB > 0;
    }
}
