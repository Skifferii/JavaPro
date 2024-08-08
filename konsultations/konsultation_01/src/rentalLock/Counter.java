package rentalLock;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static int counter;
    private static final ReentrantLock lock = new ReentrantLock();

    /* RentalLock
    lock() - захватывает блокировку. Если блокировка уже захвачена другим поток - текущий поток будет заблокирован
    до тех пор, пока блокировка не будет освобождена
    unlock() - Освобождает блокировку, позволяя другим потокам захватить ее

     */

    // Метод увеличения значения счетчика
    public static void increment() {
        // Захватываю блокировку

        lock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + ":  increment counter to: " + counter);
        } finally {
//            Обязательно освобождаем блокировку
            lock.unlock();
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.increment();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.increment();
            }
        });


        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final counter: " + Counter.getCounter());
    }
}