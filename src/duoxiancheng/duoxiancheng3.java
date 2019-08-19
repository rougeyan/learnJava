package src.duoxiancheng;

/**
 * 案例: 售票窗例子:多线程
 * 1. 售票动作需要同时执行;所以使用多线程技术
 */

/**
 *
 * 其他:start();
 *                         =>具备执行资格但不具备执行权(临时阻塞状态,非常短暂,随时有可能性)====> 冻结恢复有可能是恢复到临时阻塞状态
 *                         =
 * start();       ==========>  CPU执行资格,cpu执行权利 ====>      sleep(time)/ timeover              冻结
 *                                                             wait() 暂停 notify() 唤醒        即 释放了cpu执行资格
 *                            run 结束                                                            cpu执行权
 *                            stop() 消亡
 * 线程临时阻塞
 *
 *
 * 线程安全问题(随机性);
 *
 * 原因:
 * 分析多线程思路:
 * 1.多个线程操作共享的数据;
 * 2.线程任务操作共享数据的代码有多条(运算有多个) 即可线程任务都是在操作数据 我运算一半 另一线程又来了; 多态代码;
 *
 * 解决思路:
 * 1. 只要让一个线程在执行线程任务时将多条操作共享数据的代码执行完,
 *      在执行过程中,不要让其他线程参与运算
 *
 * 代码
 * java解决此问题:
 * 通过代码块完成, 同步代码块
 * 格式
 *
 * synchronized(对象){    // 对象相当于锁, 火车上的卫生间  --> 同步锁  3号车厢的锁 4号车厢的锁
 *  // 需要被同步的代码
 *  // 即可能共享操作的数据;
 * }
 *
 * 同步好处:
 *
 *
 * 同步的弊端:
 *  cpu 增加判定锁,降低性能
 *
 * 同步的前提:
 *
 *  必须保证多个线程在同步中使用的是同一个锁
 *
 * 解决了 多线程安全问题发生时,加入同步后,问题依旧,就要通过这个同步的前提是否正确
 *
 *
 *  同步的另外一种体现形式: 同步函数
 *  经过分析大概是this;对象
 *  函数必须被对象调用
 *
 *  验证过程: 同步代码块和同步函数的锁对象是是否同一个?
 *  若同一个 不出现错误;
 *  若非同一个, 出现错误数据;
 *
 *  同步代码块跟同步函数有什么区别?
 *  同步代码块可以指定锁,
 *  同步函数的锁是 固定的this;
 *  锁不一样;
 *  即区分锁;
 *  同步代码块较为常用;
 *
 *  静态修饰符: static关键字修饰;
 *
 *  出现问题: 不是同一个this;
 *  因为static 修饰符使用时 没有this 对象;
 *  this 随着运行加载而加载;
 *  static 使用的锁不是this 而是字节码文件对象 类名.class
 *
 *  即可ticket.class;
 *
 */
class ticket implements Runnable{
    // 1.售票数
    private static int tickets = 100;
    // 2.
    private Object obj = new Object();
    boolean flag = true;
    @Override
    public void run() {
        // 多线程通常都有训话
        if(flag){
            while(true){
                synchronized(this){
                    // synchronized(new Object()){  不是同一个锁 没有解决问题
                    if (tickets>0){
                        // 要让线程在这里稍停下 模拟问题的发生  在1的情况下出现 2个线程空闲 会出现-1 / -2的情况
                        try{
                            Thread.sleep(10);
                        }catch(InterruptedException e){

                        }
                        System.out.println(Thread.currentThread().getName() +"..."+tickets--);
                    }
                }
            }
        }else{
            while(true){
                this.sale();
            }
        }

    }

    // 使用synchronized修饰
    public static synchronized void sale(){
        if(tickets>0){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){

            }
            System.out.println(Thread.currentThread().getName() +"..."+tickets--);
        }
    }
}
public class duoxiancheng3 {
    public static void main(String[] args) {
        ticket t = new ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        // 开启线程
        t1.start();
        // t1.start(); 线程重复开启无效;会报错;
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){

        };
        t.flag = false;
        t2.start();
        t3.start();
        t4.start();
    }
}
