public class RaseMsg implements Runnable {
    private Car[] cars;

    public RaseMsg(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public void run() {
        if (!raceEnd()) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } else {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель: " + getWinner() + "!!!");
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }

    private boolean raceEnd() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getFinishingCars() == cars.length) {
                return true;
            }
        }
        return false;
    }
    private String getWinner() {
        String winner;
        int a = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getFinishTime() < cars[a].getFinishTime()) {
                a = i;
            }
        }
        winner = cars[a].getName();
        return winner;
    }

}
