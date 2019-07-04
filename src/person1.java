class persom {
    private String name;
    private int age;

    persom(String name,int age){
        this.name = name;
        this.age = age;
    }
    // 使用了访问了(成员变量)则不能加 static 静态;

    // 静态方法不能访问非静态的成员;

    public void speak(){
        System.out.println("name="+this.name+",age="+this.age);
    }
    // 方法为什么加静态? 成员修饰符;
    // 除了可以被对象调用外, 还可以被类名调用;
    // 好处是 直接能 使用 类.methods()调用
    // 即 persom.sleep();
    // 不允许出现this, super关键字;
    // 1.静态随着类的加载而加载, 随着类的小时而消失,
    // 2.静态优先于对象存在, 被对象共享;
    // 3.静态先存在与内存中, 所以无法访问非静态; 而且内部无法书写this;

    // this 没有指向;
    public static void sleep(){
        System.out.println("睡觉zzzzzzz");
    }

    // 口
}

class PersonDamo{
    // main  静态的主函数
    public static void main(String[] args){
        // 创建对象 调用;
        persom p = new persom("lisi",20);
        p.speak();
        // 静态调用
        persom.sleep();

    }
}

class MainDemo{
    // public: 权限最大
    // static 不需要对象 直接用给定的类就可以访问该函数了;
    // void: 不需要返回值
    // main 函数名, 函数入口
    // String[] args 主函数参数, 字符串属性类型的参数
    // args: arguments: 参数改名称就是一个变量名;
    // main函数是静态的;
    public static void main(String[] args){
        System.out.println("hello world!");;
        // 不能访问成员变量
//         seeshow();
    }
    // 静态修饰函数外还能修饰变量
    public void seeshow(){
        System.out.println("show run");
    }
}

class Circle{
    private double radius; // 成员变量;
    //  定义pi
    // 因为每次创建一个对象都新建一个pi ,浪费内存空间, 没必要, 因此使用static 去修饰,实现对象的共享;
    private static double pi =3.14; //静态变量;
    // 什么时候定义静态变量
    // 该成员变量对每个新建对象均为一致的时候, 就对改成员变量设置为静态, 举例如同:js中的const;
    Circle(double radius){
        this.radius = radius;
    }
    // 获取圆面积
    double gerArea(){
        // return radius*radius*Circle.pi;
        return radius*radius*pi;
    }
}
// 静态变量和成员变量的区别:
// 1. 所属范围不同
// 静态变量所属与类,成员变量所属对象,
// 静态变量成为类变量;成员变量成为实例变量;
// 2. 调用不同
// 静态变量能被对象和类调用(一般都用类名调用)
// 成员变量只能被对象调用
// 3 加载时期不同
// 静态变量随着类的加载而加载,
// 成员变量随着对象的加载而加载
// 4.内存存储区域不同
// 静态变量存储在方法区中
// 成员变量存储在堆内存中
