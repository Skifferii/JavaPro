package task_01;

public class MyThread1 extends Thread {


    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
