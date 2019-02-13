package DZ1;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    msg("A");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    msg("B");
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    msg("C");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    static synchronized void msg(String symbol) {
        System.out.println(symbol);
    }
}
