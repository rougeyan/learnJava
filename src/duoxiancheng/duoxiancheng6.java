package src.duoxiancheng;

import java.util.concurrent.locks.*;

/**
 * 解决多生产多消费的效率问题;
 * jdk1.5;之后的解决方法;
 * java.util.concurrent.locks;
 *
 * lock接口:
 * 比同步更厉害,有更多操作;
 * lock() 获取锁;
 * unlock() 释放锁;
 * 提供更加面向对象的锁,在该锁中提供更多显式的锁操作
 * 在1.5之后 可以减少synchronized的锁操作
 *
 * 异常, 不一定要处理;
 *
 * try{
 *
 * }finallu{
 *     l.unlock()
 * }
 *
 * 锁跟 lock发生了变化了
 * lock 跟 this 不是同个锁;
 */

public class duoxiancheng6 {
}
