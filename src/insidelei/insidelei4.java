package src.insidelei;

/**
 * 匿名内部类:
 * 不定义类型
 *  子类对象, 带内容的的子类独享
 * 创建abstract 对象
 *
 * 写法 new 父类or接口(){
 *     子类内容内容
 * };
 *
 *
 *
 */
public class insidelei4 {
    public static void main(String[] args) {
        // todo something
    }
}

abstract class absdemo{
    abstract void show();
    // 有两个方法;
    abstract void show2();

    // 匿名内部类就是内部类的简化形式;
    // 简化形式: 内部类必须继承父类  / 实现接口
    // 不匿名就 给变量;

    // 方法怎么调用?
}

class outerd{
    int num =3;

    public void method(){
//        new inner.show()
        /**
         * 不想创建具体的子类型,还想创建absdemo的子类对象?
         *  怎么实现呢;
         *
         *  答: 没有子类型干脆 直接使用父类, 但是抽象类之所以不能new 对象是因为抽象方法没重写, 只要重写冲向方法即可;
         */
        // new absdemo() // 它是抽象类==>不能创建对象;
        // 此对象即是重写一个absdemo对象;

        // 这种写法叫做 匿名内部类;
        // 百分之百是子类对象;
        // 带内容的子类对象;
        //
        new absdemo(){
            // 在结构体重写方法
            void show(){
                System.out.println("重写抽象show()方法");
            }
            void show2(){}
        }.show();

    }
}
