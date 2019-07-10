package jicheng;

/*
* 当一个抽象类中的方法全是抽象的.
* 这时候,可以通过另一种特殊的形式来体现
*
* 即接口表示
*
* 接口该如何定义呢?
* interface
*
*
* 接口中的成员已经被限定为估计的集中
*
* 1. 定义变量,但是变量必须由固定的修饰符修饰 public static final 所以接口中的变量也称之为常量
* 2. 定义方法, 方法也有固定化的修饰符 public abstract
* 3. 接口中的成员都是公共的.
*
* [接口的特点]
* 1. 接口不可以创建对象
* 2. 子类必须覆盖掉接口中所有的抽象方法后,子类才可以实例化;
*       否则子类是一个抽象类
* */


interface Jcinterface {
    public static final int NUM = 3;
    public abstract  void show1();
    public abstract  void show2();
}
// 继承 extends 仅仅用于class 定义的类
// 定义子类去覆盖接口中的方法 子类必须和接口产生关系,类与类的关系是继承,类与接口之间的关系是 实现
// 通过 implements
// 实现
class JcinterfaceImpl implements Jcinterface{
    // 重写接口中的方法
    public void show1(){}
    public void show2(){}
}


/*
* 多继承
*
* [接口最重要的体现]
*  解决多继承的弊端,
*  将多继承在这种机制在java中通过多实现完成
* */
//interface haha{
////    void  show1();
////}
////interface hbhb{
////    void  show2();
////}
////class hcch implements haha,hbhb{
////    public void show1(){};
////    public void show2(){};
////}
/*
* [ 如何解决多继承的弊端?]
* 弊端: 多继承时候,多个父类由相同同能是,子类调用会产生不确定行,
* 核心原因是在于多继承父类中功能由主体{}, 导致调用时运行是不确定那个主体内容
* 为什么多实现就解决呢?
* 因为接口中的功能都没有方法体, 改方法体由子类来明确
* */

//interface haha{
////    void  show1();
////}
////interface hbhb{
////    void  show1();
////}
////class hcch implements haha,hbhb{
////    public void show1(){};
////}

class interfaceDemo{
    public static void main(String[] args)
    {
        System.out.println("hellow wordl!");
    }
}
