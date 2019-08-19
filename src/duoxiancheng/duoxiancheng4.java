package src.duoxiancheng;

/**
 * 死锁
 *
 * 弊端
 * 当线程出现多个同步(多个锁),如果同步中嵌套其他同步;
 * 容易出现 死锁;
 *
 *
 * 死锁 互相不释放锁;
 * synchronized(Object1){
 *     synchronized(Object2){
 *
 *     }
 * }
 *
 * synchronized(Object2){
 *     synchronized(Object1){
 *
 *     }
 * }
 *
 * 这种情况能避免就避免;
 * 死锁程序;
 * 锁不同 互掐;
 */

//死锁例子
public class duoxiancheng4 {
    public static void main(String[] args) {
        deadLock t1 =  new deadLock(true);
        deadLock t2 =  new deadLock(false);
        Thread t11 =new Thread(t1);
        Thread t22 =new Thread(t2);
        t11.start();
        t22.start();
    }
}

class deadLock implements Runnable{
    private boolean flag;
    deadLock(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag){
            synchronized (mylock.lockA){
                System.out.println("outer lockA");
                synchronized (mylock.lockB){
                    System.out.println("inside lockB");
                }
            }
        }else{
            synchronized (mylock.lockB){
                System.out.println("outer lockB");
                synchronized (mylock.lockA){
                    System.out.println("inside lockA");
                }
            }

        }
    }
}
// 用于定义存储锁对象
class mylock {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();
}

