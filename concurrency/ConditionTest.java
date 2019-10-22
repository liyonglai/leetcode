import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyonglai
 * @date 2019/8/1
 * @description 用condition的方式实现ABCABC输出
 */
public class ConditionTest {
    private int value = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() {
        try {
            lock.lock();
            while (value != 0) {
                condition.await();
            }
            ++value;
            System.out.println(Thread.currentThread().getName() + " value " + value);
            condition.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        try {
            lock.lock();
            while (value == 0){
                condition.await();
            }
            --value;
            System.out.println(Thread.currentThread().getName() + " value " + value);
            condition.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                test.increment();
            }

        }, "AA");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                test.decrement();
            }
        }, "BB");

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                test.increment();
            }
        }, "CC");

        t1.start();
        t2.start();
        t3.start();
    }
}
