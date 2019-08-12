package src.insidelei;

public class insidelei1 {
}

/**
 *  内部类(内置类, 嵌套类) 在类中创建一个类
 *
 *  类A( 类B)  B需要访问A类
 *
 *  内部内可以 --- 直接访问 ---  外部类的所有成员 包括私有;
 *  而外部类要访问内部类 必须创建内部对象;
 *
 *
 *  描述事物的时候, 事物内部还有事物; 这个内部的事物还在访问外部事物的内容
 *
 *  这是这个事物通过内部类秒描述;
 *
 *  设计向; 写的方向很少;
 *
 *  [内部内的访问方式]
 *
 *  1.内部类在成员内部上的被访问方式;
 *
 *      被public 修饰;
 *
 *      创建outer类之后 Inner类是不进类型 要先创建对象才能创建对象;
 *
 *      不多见,更多时候,内部内已经封装到外部类中,不直接对外提供
 *
 *      被private修饰; ...略
 *
 *      被static修饰;
 *
 *      内部类被静态修饰之后,随着Oute 加载而加载,可以吧一个静态类理为 就是一个外部类;
 *      // 非静态只有创建对象才能使用,
 *      // 静态可以直接访问
 *
 *      类测试条件
 *      1.测试情况  =>  直接访问Outer中Inner内部类的非静态成员对象
 *        方法: 创建内部类的对象 内部类作为成员, 先创建对象,再有内部类对象
 *
 *        Outer.Inner in = new Outer().new Inner();
 *        in.show()
 *
 *      2.测试情况; => 对静态内部类中的非静态成员进行调用
 *          方法: 因为内部类是静态, 不需要创建Outer对象, 直接创建内部类对象就可以了;
 *
 *          Outer.Inner2 inn = new Outer.Inner2() // 内部类对象
 *
 *          inn.show2();
 *      3. 如果静态内部类中有静态成员,如何访问
 *      方法: 既然静态内部类随外部加载而加载,而且静态成员随着类的加载而加载
 *      此时就不需要创建对象
 *      Outer.Inner2.staticShow2()
 *
 *      注意事项:
 *      在非静态内中 创建一个 静态方法  // 非法: error 不可以;
 *
 *      非静态类的不允许定义静态成员, 仅允许在非静态内部类中定义 静态常量  static final
 *
 *      如果想要在内部类中 定义静态成员 此时内部类也必须要被static修饰
 *
 */
class Outer{
    private int num = 4;
    static int num2= 2;
    /**
     *  A类中
     */
    void methods(){
        System.out.println("num="+num);
        Inner h = new Inner();
        // 上面与下面一样
        Outer.Inner hh = new Outer.Inner();
        h.show();
    }
    // 在类里面定义一个类
    // haha 相当于一个成员
    // 内部类;
    public class Inner {
        void show(){
            System.out.println("num="+num);
        }
    }

    // 静态类;
    static class Inner2{
        void show2(){
            System.out.println("Inner show2 running.."+num2);
        }
        static void staticShow(){
            System.out.println("Inner2 static show 2");
        }

    }
}

class InnerClassDemo{
    public static void main(String[] args) {
        Outer out = new Outer();
        out.methods();
        // 直接访问Outer 中的内部类的费静态成员
        // 现有外部类对象 才有内部类对象
        // 非常行间
//        Outer.Inner a = new Outer.new Inner();
//        in.show();
    }
}

// 编译成
// Outer$Inner.java
// 意思是Inner 所属Outer;