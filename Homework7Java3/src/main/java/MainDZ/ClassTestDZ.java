package MainDZ;

public class ClassTestDZ {

    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }
    @Test(priority = 1)
    public static void method1() {
        System.out.println("method1");
    }
    @Test(priority = 7)
    public static void method2() {
        System.out.println("method2");
    }
    @Test(priority = 3)
    public static void method3() {
        System.out.println("method3");
    }
    @Test(priority = 5)
    public static void method4() {
        System.out.println("method4");
    }
    @AfterSuite
    public static void stop() {
        System.out.println("stop");
    }
}
