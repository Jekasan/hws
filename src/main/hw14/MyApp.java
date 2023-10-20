package hw14;

public class MyApp {
    private final Object mon = new Object();
    private int counter = 3;

    public static void main(String[] args) {
        MyApp waitNotify = new MyApp();

        new Thread(() -> {
            try {
                waitNotify.printA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                waitNotify.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                waitNotify.printC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public void printA() throws InterruptedException {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (counter != 3) {
                    mon.wait();
                }
                System.out.println("A");
                counter = 1;
                mon.notifyAll();
            }
        }
    }

    public void printB() throws InterruptedException {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (counter != 1) {
                    mon.wait();
                }
                System.out.println("B");
                counter = 2;
                mon.notifyAll();
            }
        }
    }

    public void printC() throws InterruptedException {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (counter != 2) {
                    mon.wait();
                }
                System.out.println("C");
                counter = 3;
                mon.notifyAll();
            }
        }
    }

}
