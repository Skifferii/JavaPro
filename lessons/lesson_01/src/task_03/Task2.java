package task_03;
public class Task2 {

    private static int counter = 0;

    public static void main(String[] args) {

        int x = 1000;
        String str = "" + x;
        System.out.println(str + "!!!");
        System.out.println((String.valueOf(x) + 222));

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            incrementCounter();
        }

        try {
            // Таким образом мы просим главный поток остановиться
            // и дождаться завершения работы других потоков
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("counter: " + counter);

    } // main

    public static synchronized void incrementCounter() {
        counter++;
    }
}
