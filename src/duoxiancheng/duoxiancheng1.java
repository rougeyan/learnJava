package src.duoxiancheng;

/**
 * 进程: 正在进行中的程序,应用程序 运行时耗费的内存空间 在内存占用的空间;
 *  空间的分配;
 *  执行单元: 从头到尾 =>执行的单元
 *  QQ => 聊天 => 执行单元1 (即线程)
 *     => QQ游戏 => 执行单元2(线程)
 *     => QQ宠物 => 执行单元3 (线程)
 *
 *  360 => 体检功能
 *      => 扫描文件
 *      => 漏洞修复
 *      => 删除垃圾
 *
 *  一个进程至少有一个线程 可以有多个线程 多线程程序
 *
 * 线程: 多线程;
 * 可以实现多部分程序同时执行; 即 并发执行;
 *
 * 多线程的使用可以合理使用cpu 资源 线程过多会导致降低性能;
 *
 *   extends Thraad
 *   过程
 *   1.定义一个类继承Thread
 *   2.重写run方法
 *   3.创建子类对象 就是创建线程对象
 *   4.调用start方法, 开启线程并让线程执行 同事还会告诉jvm去调用run方法;
 *
 *  为什么要继承? 以及重写run的内容
 *  Thread t1 = new Thread();
 *  t1.start()
 *  run 方法没做什么事情;
 *  更重要的事并没有定义我们需要的内容
 *
 *  创建线程的目的是什么?是为了单独执行路径,让多部分代码同时执行;
 *
 *  也就是说线程创建执行需要给定的代码;(即线程任务)
 *
 *  run 内容即我们同时执行的部分;
 *
 *  主线程跟新开的线程是并列的
 *
 *  进程运行是否完成取决于是否还有存货的线程
 *
 *  // 获取线程名字 => 获取线程对象
 *
 *  Thread.currentThread().getName()
 *
 *  线程异常 只对当前所在线程结果 对其他线程无影响;
 */

/**
 * 通过代码演示之前和之后的区别;
 */
public class duoxiancheng1 {
    /**
     * 主线程;
     */
    public static void main(String[] args) {
//        System.out.println("Hello World");
        threadDemo1 d1 = new threadDemo1("小强");
        threadDemo1 d2 = new threadDemo1("旺财");
        d2.start(); // 将d2这个线程开启;
        d1.run(); //由主线程负责;

        // 这里结果不确定 因为由CPU确定
        /**
         * 线程调用run /start的方法
         *
         * run 仅仅是调用对象方法,
         * 调用start 开启线程同时执行run方法;
         */
    }
}

class threadDemo1  extends Thread{
    private String name;
    threadDemo1(String name){
        this.name = name;
    }
    public void  run(){
        for (int i = 0; i < 50; i++) {
            System.out.println("name="+name+"..."+Thread.currentThread().getName()+".."+i );
        }
    }
}