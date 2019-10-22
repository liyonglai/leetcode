/**
 * @author liyonglai
 * @date 2019/8/21
 * @description
 */
public class AlternatePrint {
    private int value = 1;

    /**
     * wait,notify 必须在持有锁对象的方法内成对出现，并且wait方法必须在while中使用不能用if
     * condition的wait和signalAll方法也必须出现在同一个锁对象的lock,unlock代码块中
     */
    private synchronized void printA() {
        while (value % 2 == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(value + " ");
        value++;
        this.notify();
    }

    private synchronized void printB(){
        while (value % 2 != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(value + " ");
        value++;
        this.notify();
    }
    public static void main(String[] args) {
        AlternatePrint alternatePrint = new AlternatePrint();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 25; i++) {
                alternatePrint.printA();
            }
        }, "A");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 25; i++) {
                alternatePrint.printB();
            }
        }, "B");

        t1.start();
        t2.start();
    }
}
