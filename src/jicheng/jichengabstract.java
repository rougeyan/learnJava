package jicheng;

public class jichengabstract {
}

/*

abstract
不关注具体类 我想犬科叫 但是我不值得全科由多个类; 都叫都叫;

[ 抽象类的特点 ]
1. 抽象类和抽象方法都需要被abstract修饰
抽象方法一定要定义在抽象类中
2. 抽象类不可以创建实例: 原因 调用抽象方法没有意义
3/ 只有覆盖了抽象类中所有的抽象方法后,其子类才可以实例化.
否则该子类还是一个抽象类

之所以继承,更多的是在思想,是面对共性类型操作会更简单


细节:
1.抽象类一定是个父类
    是的,因为不断抽取而来的
2.抽象类是否由构造函数?
    有,虽然不能给自己的对象初始化,但是可以给自己的子类对象初始化
    抽象类和一般类的异同点:
    相同:
        都是用来描述书屋
    不同:
        1.一般类可以有具体的描述事物, 抽象类描述事物的信息不具体
        2. 抽象类中可以多定义一个成员:抽象函数
        3. 一般类可以创建对象,而抽象类不能创建对象.
3. 抽象类是否可以不定义抽象方法
    是可以的,那这个抽象类存在的意义是什么?
        仅仅是不让该类创建对象
4. 抽象关键字 abstract不可以和哪些关键字共存?
    1. final
    2. private
    3. static

*/


/**
 * 需求: 公司程序员有姓名,工号,薪水,工作内容
 * 项目经理拥有姓名,工号,薪水,工作内容 还有奖金,工作内容
 * 对给出需求进行数据建模
 * <p>
 * 程序员:
 * 属性:姓名,工号,薪水
 * 行为:工作
 * 项目经理:
 * 属性:姓名,工号,薪水,奖金
 * 行为:工作
 * <p>
 * 这些对象是否有关系呢?  他们之间的共性, 存在关系
 * 共同抽取 员工
 * <p>
 * 员工:
 * 属性:姓名,工号,薪水
 * 行为:工作
 * <p>
 * 员工的工作内容是不具体的, 应该是抽象的, 由具体的子类体现.
 * work 不应该西方到实例对象;
 */

abstract class Employee {
    private String name;
    private String id;
    private double pay;

    /*
     *  构造一个员工对象,一开始具备这三个属性
     * */
    public Employee(String name, String id, double pay) {
        this.name = name;
        this.id = id;
        this.pay = pay;
    }

    /* 工作行为 */
    // 对于各类型自员工的工作内容是不具体的
    public abstract void work();

}

class Programmer extends Employee {
    Programmer(String name, String id, double pay) {
        super(name, id, pay);
    }

    public void work() {
        System.out.println("coding...");
    }
}

class Manager extends Employee {
    private double bonus;

    Manager(String name, String id, double pay, double bonus) {
        super(name, id, pay);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("manage...");
    }
}

class abstractTest {
    public static void main(String[] args) {
        System.out.println("hellow wordl!");
    }
}