package src.duoxiancheng;

import java.util.concurrent.locks.*;

/**
 * 多线程间的通讯
 *
 * 多个线程 但是多个线程不是做同一件事,
 * A 生产(任务) 玩具(资源)
 * B 消费(任务) 玩具(资源)
 *
 *  AB的 执行任务不相同, 但是处理的资源相同: 线程的通讯
 *
 * 生产者,消费者问题(必须掌握)
 *
 * 应用案例;
 *
 * 1. 数据错误 已经被生产很久的商品 后来才被消费
 *  解决方法: 使用同步函数 加入同步修饰,解决线程安全问题;
 *
 * 2. 数据重复
 *  问题: 连续生产没被消费, 同时消费同一个生产内容
 *  消费者 在时间片区里面消费是的count++ 结果后的生产内容;
 *  期望结果: 生产一个消费一个;
 *
 *
 *  使用等待和唤醒
 *  wait(); 等待
 *  notify(); 唤醒;
 *
 *  解决方法
 *  if(flag){
 *      try {
 *         wait();
 *       }catch (InterruptedException e){}
 *  }
 *  flag = true;
 *  notify();
 *
 *  解析:
 *  wait();  让线程处于等待状态,就是讲线程临时存储到线程池中;
 *  notify(); 唤醒; 会唤醒线程池中任意一个等待的线程;
 *  notifyAll(); 会唤醒线程池中所有的等待的线程;
 *
 *  这些方法必须使用在同步中,因为必须要标识 wait,notify,
 *  同一个锁上的notify, 只能唤醒该锁上被唤醒的wait线程;
 *
 *  为什么方法定义在obj中;
 *  因为这些方法必须标识所属的锁;
 *  因为锁是可以任意的;
 *  任意对象可以调用的方法必然是object类中的方法;
 *
 *  多生产者多消费:
 *  问题1:
 *  被唤醒的线程没有判定标记;
 *  造成生产两个消费1个;
 *  解决方法: 只要被唤醒的线程必须判断标记;
 *  while(flag)
 *
 *  while(true)并非死循环, this.wait() 线程不执行
 *
 *  多生产多消费必须是while( 判断条件) 不要使用if()
 *
 *  问题2: 死锁
 *  线程不执行 互相不释放 即死锁;
 *
 *  生产方自己唤醒线程池的生产方, 本方唤醒了本方
 *
 *  期待结果: 本方唤醒对象;
 *  使用notifyAll();
 *
 *  效率较低;
 *
 */
public class duoxiancheng5 {
    public static void main(String[] args) {
        // 1. 创建资源对象
        resource r2 =new resource();
        productor pro =  new productor(r2);
        consumer con =  new consumer(r2);
        Thread t1 = new Thread(pro); // 生产者 0
        t1.start();
        Thread t3 = new Thread(pro); // 生产者 1
        t3.start();
        Thread t2 = new Thread(con); // 消费者 2
        t2.start();
        Thread t4 = new Thread(con); // 消费者 3
        t4.start();
    }
}
// 描述资源
class resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    // 定义锁对象;
    private java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

    // 提示设置方法
    public void set(String name){ // 加入同步
        // 获取锁;
        lock.lock();

        try{
            if(flag){
                try {
                    this.wait();
                }catch (InterruptedException e){
                }
            }
            // 给成员变量赋值 并且加上编号
            this.name = name +count;
            // 编号自增
            count++;
            // 打印商品
            System.out.println(Thread.currentThread().getName()+"生产者"+this.name);

            // 理想状态下没输出 生产者前 不能被消费者使用
            flag = true;
            this.notify();
        }finally {
            lock.unlock();
        }

    }
    public void out(){
        lock.lock();
        try {
            if (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "消费者" + this.name);
            flag = false;
            this.notify();
        }finally {
            lock.unlock();
        }

    }

    // 获取商品


}
// 描述生产者
class productor implements Runnable{
    private resource r;
    // 生产这一初始化就要有资源 ,需要将资源传递到构造函数中
    productor(resource r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.set("面包");
        }
    }
}
// 描述消费者
class consumer implements  Runnable{
    private resource r;
    // 生产这一初始化就要有资源 ,需要将资源传递到构造函数中
    consumer(resource r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.out();
        }
    }
}
