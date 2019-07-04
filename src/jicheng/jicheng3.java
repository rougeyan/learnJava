package jicheng;

public class jicheng3 {
}


//重点在于成员的体现
// 1 成员变量. 重点明确明确原力
// 特殊情况
//    1.1 子类和父类定义了一摸一样的成员变量.都存在与子类对象中, 子类对象通过super来直接访问父类变量
//     this: 代表本类的对象引用; super 代表父类的内存空间
//        出现情况较少,一旦父类描述完属性,子类直接使用即可
// 2. 成员函数
//特殊情况
// 2.子类和父类定义了一摸一样的函数  函数的 override(覆盖/复写/重写);
//  使用场景 行为一样 内容不一样 即可考虑重写;重新在
//  show() {
//      super.show();
//  }
//注意事项
//2.1. 子类覆盖父类,必须保证权限大于或者等于父类的权限
// [Java权限修饰符private、default（一般省略）、public、protected](https://blog.csdn.net/sdjadycsdn/article/details/81560096)
// fu:
// void show()         // private
// Zi:
// public void show()
//2..2 静态覆盖静态 无论是 子是static 还是父static 均不可;
// 必须同为static 函数的范围类型 函数名 蚕食列表都要一样;
// 3. 构造函数
// 先执行父类的构造函数,再执行子类的构造函数
// 因为子类的所有构造函数第一行都有一句隐式语句 super(); // 默认调用的是父类的空参数的构造函数;
// 子类中的构造函数 为什么有一句隐式的super()呢?
// 原因: 子类会继承父类的内容,所以子类再初始化的时,必须先找到父类中去执行父类的初始化动作,才可以更方便使用父类中的内容;
//  注意事项:
// 当父类中没有空参数构造函数时候, 子类的构造函数必须同构显示super()语句指定要访问的父类中的构造函数
// 子例实例化过程;

//  其他细节
//  1.如果子类的构造函数 第一行写了this() 调用本类其他构造函数, 那么super调用父类语句不存在, 因为this() / super 只存在一次;
//  2.父类狗赞函数是否有隐式的 super() :  有的,构造函数默认第一行都是super(); 父类的父类是对象Object;
class fu {
    private int num1 =3; // 父类私有 子类不可以直接访问;
    int num2 = 3;
    // 空参数构造函数最好写一下
    fu(){
        System.out.println("fu");
    }
    fu(int x){
        System.out.println("fu constructor run"+x);
    }
    fu(String x){
        System.out.println("String"+x);
    }
    void show(){
        System.out.println("iam fu");
    }
}
class Zi extends fu{
    int num2 = 4;
    Zi(){
        // 隐式 super()
        System.out.println("zi");
    }
    Zi(int x){
        // 隐式 super()
        // 显示调用父类构造函数;
        super(x); // super(9); 使用x / 具体均可;
        System.out.println("zi constructor run");
    }
    Zi(String x){
        this();
    }
    void show(){
        super.show();
        // System.out.println(num1); /// error
        System.out.println("zi类的num2是"+num2);
        System.out.println("父类类的num2是"+super.num2);
//        System.out.println(this);  // 哈希值
//        System.out.println(super);  无法单独出现super;
    }
}
class fuDemo{
    public static  void main(String[] args){
        Zi zi = new Zi();
        Zi zi2 = new Zi(6);
        zi.show();
        zi2.show();
    }
}