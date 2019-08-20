package src.duoxiancheng;

import java.util.concurrent.locks.*;


/*
需求：
作为一个示例，假定有一个绑定的缓冲区，
它支持 put 和 take 方法。如果试图在空的缓冲区上执行 take 操作，
则在某一个项变得可用之前，线程将一直阻塞；如果试图在满的缓冲区上执行 put 操作，
则在有空间变得可用之前，线程将一直阻塞。我们喜欢在单独的等待 set 中保存 put 线程和 take 线程，
这样就可以在缓冲区中的项或空间变得可用时利用最佳规划，
一次只通知一个线程。可以使用两个 Condition 实例来做到这一点。
思路：
步骤：
*/
class BoundedBuffer {
    final Lock lock = new ReentrantLock(); // 锁
    final Condition notFull  = lock.newCondition(); // 生产 - 监视对象
    final Condition notEmpty = lock.newCondition(); // 消费 - 监视对象

    final Object[] items = new Object[100]; // 存储 容器
    int putptr, //生产者使用角标
        takeptr, // 消费者使用角标
        count; //计数器

    // 生产者使用方法, 往数组中存 商品
    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) //判定计数器是否满了
                notFull.await(); // 生产等待
            items[putptr] = x; // 按照角标存储到数组中
            if (++putptr == items.length) putptr = 0; // 如果存储的角标到数组的长度,将角标归0;
            ++count; // 计数器自增
            notEmpty.signal(); // 唤醒一个消费者
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) // 如果计数器为0 说明没有商品 消费者等待
                notEmpty.await();
            Object x = items[takeptr]; // 从数组中通过消费者获取商品
            if (++takeptr == items.length) takeptr = 0; // 如果消费的角标等于数组长度 将角标归0
            --count; // 计数器自检
            notFull.signal(); // 唤醒生产者
            return x;
        } finally {
            lock.unlock();
        }
    }
}