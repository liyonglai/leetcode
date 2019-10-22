import java.util.concurrent.*;

/**
 * @author
 * @date
 * @description
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 5,
            TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024),
            new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch count = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count.countDown();
            });
        }
        latch.countDown();
        count.await();
        threadPool.shutdown();
    }

    private static void test() {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "hello");
            System.out.println("hello");
        }, "t1");
        t1.start();
        LinkedBlockingQueue queue = new LinkedBlockingQueue(1024);
    }
}
