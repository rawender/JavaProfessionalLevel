import DZ2.ArrAfterFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrAfterFourTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2}, new int[]{1,2,4,4,2,3,4,1,7}},
                {new int[]{1,7}, new int[]{1,2,0,0,2,3,0,1,7}},
                {new int[]{1,7}, new int[]{1,2,4,4,2,3,4,1,7}},
                {new int[]{2,3,0,1,7}, new int[]{1,2,4,4,2,3,0,1,7}}
        });
    }
    private ArrAfterFour test;
    private int[] arrA;
    private int[] arrB;
    public ArrAfterFourTest(int[] arrA, int[] arrB) {
        this.arrA = arrA;
        this.arrB = arrB;
    }
    @Before
    public void init() {
        test = new ArrAfterFour();
    }
    @Test
    public void testTask1() {
        Assert.assertTrue("Массивы не совпадают", Arrays.equals(arrA, test.methodArrAfterFour(arrB)));
    }
}
