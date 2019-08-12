package src.insidelei;

/**
 * 为什么内部类就能直接访问外部类中的成员
 * 那是因为内部类其实持有了外部类的引用;  外部类.this
 *
 * 对与静态内部类就持有外部类.this,而是直接引用 外部类名.
 * outer.this.name outer的name
 * this.name 当前类的this;
 *
 * 其实内部类也可以定义在外部类的局部位置上;
 * 不能被成员修饰符 public private static 不能修饰;
 * 这种写法:很少见;
 * 内部类在局部时,只能访问被final修饰的局部变量;
 * 语法规则: 规定的;
 *
 * 为什么? 因为编译生成的class中直接操作最终的值 即final;
 *
 * 因为编译生成的class中
 *
 * 为什么不能访问非最终的局部变量呢?
 */

public class insidelei2 {
    public static void main(String[] args) {
        outera a = new outera();
        a.method();
        outerb b = new outerb();
        b.method();
    }
}

class outera{
    int num =3;

    Object obj;

    // 成员内部类
    class inner{
        int num = 4;

        void  shows(){
            int num = 5;
            System.out.println("num="+num); // 5
            System.out.println("num="+this.num); // 4
            System.out.println("num="+outera.this.num); //3
        }
    }

    void method(){
        final int x = 6;
        int y = 12;
        new inner().shows();

        // 局部内部类:

        // 在methods 方法中 有个又一个内部类;
        // Outer$1xxx 局部内部类 在methods 中
        class methodsinner{
            void  showssss(){
                System.out.println("x="+x);
                System.out.println("y="+y); //
            }
        }
        // 局部内部类调用
        new methodsinner().showssss();
        // 延长了生命周期;
        // 加入引用了, 延长了生命周期;
        //  y所属于 methods;
        // methods 已经出栈了;
        obj = new methodsinner();
    }
    public void fuc(){

    }
}


class outerb{
    Object obi;
    public void method(){
        int y = 9;
        class inner{
            public String toString(){
                return "ahha"+y; //假设能访问
            }
        }
//        obj = new inner(); // gei obj 赋一个inner对象;
    }
    public void func(){
//        obj.toString();
    }
}
