package src.duoxiancheng;

/**
 * runnable: 创建线程的第二张方式
 * 实现runnable 接口;
 * 因为java只迟滞单继承,
 * [java--（多线程创建的两种方式Thread类和Runnable接口）](https://blog.csdn.net/qq_32823673/article/details/78657281)
 *
 *  使用方式:
 *  1.定义类实现runnable接口,避免了继承的Thread类的局限性;
 *  2.覆盖接口中的run方法,将线程任务代码定义到run方法中
 *  3.创建threadDemo2 的对象, 只有创建Thread类的对象才可以开启线程
 *  4.将runnable接口的子类对象作为参数传递给Thread类的构造函数
 *      因为线程已经被封装到Runnable接口的run方法当中; 而这个run方法所属于Runnable接口的子类对象;
 *      所以将这个子类对象作为参数传递给Thread的构造函数,
 *      这样,线程的创建时就可以明确要运行的线程任务
 *
 *  5.调用thread类的start方法开启线程
 *
 *      实现Runnable的接口方式更加符合符合面向对象,
 *      线程分为两部分, 1.线程对象 2.线程任务
 *      继承Thread类. 线程对象和线程任务耦合在一起; 既有线程对象,又有线程任务;
 *      实现Runnable 可以 线程对象 和 线程任务 可以进行解耦;
 *
 *  好处:
 *  为什么实现接口?
 *  原来: 创建子类对象 => 直接继承,开启线程; 因为继承有start();方法;
 *
 *  使用runnable 多继承在java不可以使用;
 *
 *   person  => student 不能再继承 Thread
 *   student 有额外功能, 有一个线程任务  即拓展功能 即接口;
 *   student implements Runnable
 *   student 去重写run() 方法即可;
 *      不能保证没有父类;
 *
 *   实现runnable接口避免了单继承的局限性
 *   较为常用
 *
 *   为什么子类对象作为参数传入到Thread类的构造函数中?
 *
 *   即传递run()代码;
 *
 *
 *
 */

public class duoxiancheng2 {
    public static void main(String[] args) {
        threadDemo2 d3 = new threadDemo2("线程");
        Thread thread1 = new Thread(d3);
        Thread thread2 = new Thread(d3);
        thread1.start();
        thread2.start();
    }
}
class threadDemo2 implements Runnable{
    private String name;
    threadDemo2(String nane){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("name="+name+"..."+Thread.currentThread().getName()+".."+i );
        }
    }
}

