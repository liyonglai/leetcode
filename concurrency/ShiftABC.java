import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyonglai
 * @date 2019/8/1
 * @description 三个线程轮流打印ABCABCABC...共打印10次
 */
public class ShiftABC {
    private int value = 0;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void printA(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (value % 3 != 0) {
                    conditionA.await();
                }
                System.out.print("A");
                value++;
                conditionB.signal();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (value % 3 != 1) {
                    conditionB.await();
                }
                System.out.print("B");
                value++;
                conditionC.signal();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (value % 3 != 2){
                    conditionC.await();
                }
                System.out.print("C");
                value++;
                conditionA.signal();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ShiftABC print = new ShiftABC();
        Thread t1 = new Thread(()->{
            print.printA();
        }, "AA");
        Thread t2 = new Thread(()->{
            print.printB();
        }, "BB");
        Thread t3 = new Thread(()->{
            print.printC();
        }, "CC");
        t1.start();
        t2.start();
        t3.start();
    }
}
