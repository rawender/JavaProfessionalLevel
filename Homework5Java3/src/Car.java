import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT = 0;
    private static int finishingCars = 0;
    private Race race;
    private int speed;
    private String name;
    private long finishTime;
    private static CyclicBarrier startFinish = new CyclicBarrier(Main.CARS_COUNT, new RaseMsg(Main.cars));

    public long getFinishTime() {
        return finishTime;
    }

    public int getFinishingCars() {
        return finishingCars;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 1000));
            System.out.println(this.name + " готов");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            startFinish.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        finishingCars++;

        finishTime = System.currentTimeMillis();

        try {
            startFinish.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
