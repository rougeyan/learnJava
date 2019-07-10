package jicheng;

/*
* 继承的弊端:
*  1. 打破封装性,
*  解决方法: 不让其他类继承该类,就不会有重写;
*  通过java中的一个关键字,final(最终化)
*  [ final 关键字]
*  是一个修饰符,可以修饰类 方法 变量(成员变量,局部变量, 静态变量)
*  [ 特点 ]
*  1. final修饰的类是一个最终类,不能在派生子类;
*  2. final修饰的变量是一个常量,只能被赋值一次;
*  什么时候会在程序中定义final常量呢?
*  当一个程序中的数据使用时是固定不变的,这是为了增加阅读性,可以给该数据加入修饰符;
*  这就是变量,为了保证这个变量的值不被修饰,加上final 修饰,变成一个阅读性很强的常量
*  书写规范,被final修饰的常量名所有的字母都是大写的,如果由多个单词组成,单词间通过_链接
*  例
* */
/*final*/ class foo{
    /*final*/ void show(){
        // 系统的功能
    }
}
class zi extends foo{
    // 重写了
//    static final int number=9; 需要赋值
    static final double PI = 3.14; //为了访问方便 加入static
    void show(){
        final int count = 21;
//        count = 2; //error
        System.out.println(count);
    }
}
public class jichengfinal {
}
