import DZ3.FindOneFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class FindOneFourTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true, new int[]{1,2,3,4}},
                {true, new int[]{1,1,1,1}},
                {true, new int[]{4,4,4,4}},
                {true, new int[]{1,4,1,4}}
        });
    }
    private FindOneFour test;
    private boolean res;
    private int[] arr;
    public FindOneFourTest(boolean result, int[] arr) {
        this.res = result;
        this.arr = arr;
    }
    @Before
    public void init() {
        test = new FindOneFour();
    }
    @Test
    public void testTask2() {
        Assert.assertEquals(res, test.methodFindOneFour(arr));
    }
}
