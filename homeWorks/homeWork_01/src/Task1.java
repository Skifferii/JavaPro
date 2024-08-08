public class Task1 {

    private static int counter;

    public static synchronized void incrementCounter() {
        counter++;

    }


    public static void main(String[] args){
        singleThereadSolution();
        counter = 0;
        twoThereadSolution();
    }

    public static void twoThereadSolution(){
        MyThread myThread1 = new MyThread(1,1_000_000);
        MyThread myThread2 = new MyThread(1_000_001,2_000_000);

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter value  single thread: " +counter);



    }
    public static void singleThereadSolution() {
        MyThread myThread = new MyThread(1,2_000_000);
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter value  single thread: " +counter);
        System.out.println(Thread.currentThread().getName() + " clsing");
    }

}