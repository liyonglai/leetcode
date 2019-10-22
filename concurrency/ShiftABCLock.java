import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyonglai
 * @date 2019/8/2
 * @description 使用锁实现ABCABC....ABC
 */
public class ShiftABCLock {
    private Lock lock = new ReentrantLock();
    private volatile int value = 0;
    public synchronized void print(){
        try {
//            lock.lock();

            if (value % 3 == 0) {
                System.out.print("A");
            }
            if (value % 3 == 1) {
                System.out.print("B");
            }
            if (value % 3 == 2) {
                System.out.print("C");
            }
            value++;

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ShiftABCLock shiftABCLock = new ShiftABCLock();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {

                shiftABCLock.print();
            }
        }, "A");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {

                shiftABCLock.print();
            }
        }, "B");

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {

                shiftABCLock.print();
            }
        }, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}
