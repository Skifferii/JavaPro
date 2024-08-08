package task_02;

public class Task2 {

    static int counter = 0;

    public static void main(String[] args) {

        MyThread myThread1;
        myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            counter++;
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

    }
}
