package src.duotai;

import java.time.Period;

/**
 * Object 最上层
 * object类中的常用方法;
 *
 * object 类是所有类的根类,定义了所有对象都具备的功能
 * object.equals();
 * object.toString();
 *
 *
 */
class Peson extends Object{
    private int age;
    Peson(int age){
        this.age = age;
    }
    // 判定同龄人 这个方法也是在比较两个person 对象是否相等
    // 注意 person 类中是否有比较两个person 对象相等的方法? 有!
    // 有 因为继承object 它本身具备着equials 放阿飞
    //
    public boolean compare(Peson p){
        return this.age == p.age;
    }
//    public boolean equals(Object p){
//        return this.age = p.age; // error  成员变量 编译运行全看左边;
//    }

    // 这里传什么都可以 不合理 传个一个 new Dog 都可以;

    // age是Peson类型的属性 既然用到子类型的内容 需要向下转型;

    // 如果调用该方法对象和传递进来的对象时同一个对象 就不要转型和判定,直接返回true

    // **********重要程度**************

    // 以后判断对象是否相同 就要覆盖equals 方法;

    public boolean equals(Object p){
        if(this == p)
            return true;

        if(!(p instanceof Peson))
            throw new ClassCastException("类型错误,请传入Peson类");

        Peson q = (Peson)p;
        return this.age == q.age;
    }
    @Override
    public String toString(){
        return "Person[age ="+age+"]";

    }
}
public class duotaiobject1
{
    public static void main(String[] args) {
        Peson p1 = new Peson(3);
        Peson p2 = new Peson(4);
        System.out.println(p1 ==p2); //false
//        System.out.println(p1.equals(p2)); //false
//        System.out.println(p1.compare(p2));
        // equals
        System.out.println((p1.equals(p2)));
        /**
         * toString
         */
        System.out.println(p1); //Peson@61bbe9ba
        System.out.println(p1.toString());
    }
}
