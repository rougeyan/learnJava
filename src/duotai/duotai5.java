package src.duotai;

/**
 * 多态中成员调用的特点;
 * 1. 成员变量
 *  当子父类中出现同名的成员变量时候,
 *      多态调该变量的时候;
 *          编译时期: 参考的是引用型变量所属的类中是否有被调用的成员变量, 没有则编译失败;
 *          运行时期: 也是调用引用型变量所属类的成员变量
 *
 *          简述: 编译和运行 均参考 等号左边;
 * 2. 成员函数
 *    编译检查无对象,
 *    运行时 子类对象重修父类, 运行结果是 子方法();
 *    函数 以子为主, 子会访问自己的成员变量
 *    编译 参考左边, 如果没有编译失败,
 *    编译运行看右边
 *    对与成员函数, 是动态绑定到对象上,  方法必须被 对象调用;
 *    谁调用我 绑定谁;
 *
 * 3. 静态函数
 *      编译和运行都参考 左边;
 *      静态函数是绑定到类上;
 *
 *      前排提示: 静态方法是不会被多态调用的;
 *      因为静态方法不属于对象, 属于类; 根本不需要对象来调用方法 直接f.methods()即可;
 * 总结
 *  1.成员变量 静态变量: 只看左边
 *  2 成员变量 编译看左边 运行看右边;
 *
 *
 */

class fuu {
    int num = 3;
    void show(){
        System.out.println("fu show run"+num);
    }
    static void close(){
        System.out.println("fu close run");
    }
}

class zi extends fuu{
    int num = 5; // 用super 区分;
    void show(){
        System.out.println("zi show run"+num);
    }
    static void close(){
        System.out.println("zi close run");
    }
}



public class duotai5 {
    public static void main(String[] args) {
        testvarvalue();
        testvarMethods();
    }
    public static void testvarvalue(){
        System.out.println("测试成员变量结果");
        // 用什么访问就出现什么结果;
        fuu f = new zi(); // 3 因为定义了它是父类型;
        zi z = new zi(); // 5  因为定义了它是子类型;
        System.out.println(f.num);
        System.out.println(z.num);

    }
    public static void testvarMethods(){
        fuu ff = new zi();
        zi zz = new zi();
        ff.show(); //
        ff.close();

    }
}
