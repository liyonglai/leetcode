public class VolatileTest {
    public volatile int i = 0;
    public int increment(){
        return this.i += 60;
    }

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                // 线程睡一小段时间，保证主线程往下执行，否则会因为t1线程执行太快导致看不出效果
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.increment();
            System.out.println("t1 execute and i increment, value " + v.i );
        }, "A");

        t1.start();
        while (v.i == 0) {}
        Thread t2 = new Thread(()->{
            System.out.println("t2 execute and i value is " + v.i);
        }, "B");
        for (int i = 0; i < 100; i++) {
            new Thread(()->{

            }, String.valueOf(i)).start();
        }
        t2.start();
    }
}