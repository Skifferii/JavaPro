package task_03;
public class MyThread extends Thread{


    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Task2.incrementCounter();
        }

        System.out.println(Thread.currentThread().getName() + " завершил работу");
    }
}
