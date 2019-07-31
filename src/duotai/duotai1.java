package src.duotai;

/**
 * 多态:
 *  提高扩展性
 *  动物: 吃
 *  狗: 吃(){}; 喝(){}; 看门(){};
 *  猫: 吃(){}; 喝(){}; 抓鱼{}{}; 看门(){};
 *
 */

class Dog extends Animal{
    public void  eat(){
        System.out.println("骨头");
    }
    public void  lookHome(){
        System.out.println("看门");
    }
}

class Cat extends Animal{
    public void  eat(){
        System.out.println("鱼");
    }
    public void  catchFish(){
        System.out.println("抓鱼");
    }
}

/**
 * 对共性功能进行抽取;
 * 抽象类定义抽象方法;
 *
 */
abstract class Animal{
    public abstract void eat();
}

/**
 * dog是Animal 的一种, cat也是 同一个事物
 *  Dog a = new Dog();
 *  Cat b = new Cat();
 *
 *  Animal c = new Dog(){};  父类型指向具体对象
 *  Animal d = new Cat(){};
 *
 *  猫狗不看 看动物
 *
 *  // 建立了animal的引用技能接收狗也能接收猫
 *
 *  旧:
 *  本类型 ==>(指向) 本类对象
 *  过渡成
 *  多态:
 *  父类型 ==>(指向) 本类对象
 *
 *  面向对象: 第三特征 多态;
 *
 *  体现:
 *     父类的引 / 接口的引用 用指向了自己的子类对象;
 *
 *     Dog d = new Dog(); // Dog对象的类型是Dog类型;
 *     Animal a = new Dog(); // Dog对象的类型 右边是Dog类型 左边 是Animal类型
 *     // 具备两种表现形态;(既是狗, 又是动物类型);
 *
 *     好处:
 *      提高程序的扩展性, 不关心多少个子类, 只要是我的子类 我都能使用
 *     弊端:
 *      通过父类引用操作子类对象的时候, 只能使用父类中已有的方法,(即共性功能), 不能使用子类持有的方法;
 *
 *
 *      不再过分面对细节事物,
 *      隐藏实现细节,对外提供接口;
 *      接口!== interface
 *      广义理解: 公共对外 暴露都可以称之为接口;
 *
 *     前提
 *      1. 必须有关系; (继承/ 实现)
 *      2. 通常都有重写操作. 运行都是重写中的内容;
 *      3. 父类调用自己的方法 但是操作的是子类的内容;
 *
 *
 *    问题来了:
 *
 *    子类的特类方法 如何调用?
 *
 *    Animal a = new Dog(); // 多态的代码体现
 *    // 到底做了什么事?
 *    答: Animal 是父类型, new Dog 子类型;
 *    但是父类型引用指向子类对象时,就是让子类对象 进行了类型的提升(向上转型)
 *
 *    向上转型, 提高扩展性, 直接隐藏了子类型, 不能使用子类型的特有方法,
 *    // 假如要使用子类型 只有子类型能使用
 *
 *    可以向下转型 强制转换
 *
 *    Animal a = new Dog();
 *
 *    Dog d = (Dog)a; // 将 Animal a 类型转型为Dog 类型;
 *    d.lookHome();
 *    向下转型什么时候用?  当需要使用子类型特有的内容是.
 *
 *    注意, 无论向下转型/ 向下转型 都是子类对象 进行类型转行
 *    都是 new Dog() 进行类型转换  Animal(父类型) / Dog(本体类型)
 *
 *    [向下转型注意事项]:
 *
 *    Animal a = new Dog();
 *    Cat c = (Cat)a;
 *    向下转型因为不明确子类对象类型,所以容易引发 classCastException 异常
 *
 *    所以为了避免这个问题, 需要在向下转型前,做类型判断;
 *
 *    判断类型 使用关键字 instanceof 所属谁的谁的实例;
 *
 *    if( a instanceof Cat){
 *        // a 指向的是Cat 类型;
 *        将a 转型成Cat() 类型
 *
 *        Cat c = (Cat)a;
 *    }else if( a instance of Dog){
 *        Dog d = (Dog)a;
 *    }
 *
 *    [转型总结]
 *    1. 什么时候使用向上转型?
 *     1. 提高程序的扩展性, 不关系子类型(子类型被隐藏)
 *      判定你需要用子类的特有方法吗? ...
 *      不需要关系子类型
 *     2. 什么时候需要向下转型?
 *      需要使用子类型的特有方法: 例如狗的看门
 *
 *
 *
 *
 */

class duotaiDemo{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.lookHome();
        Animal dd = new Dog();
        dd.eat(); // 可以
        // dd.lookHome(); // 错误 ..不可以  小动物看家, 你不知道小动物是什么
    }
    public static void methods(Animal a) {
        a.eat(); // 也就只有共性方法可以调用;
//        a.lookHome() // 错误 因为你传一个dog可以  但是传一个猫不行
        // lookhome 只是某一个子类的方法 动物不具备此功能
    }
}


class duotaiDemo222{
    public static void main(String[] args) {
        Dog d = new Dog();
        methods(d);

        Cat e = new Cat();
        methods(e);
    }
    public static void methods(Animal a) {
        // 因为调用的不定性;
        a.eat();
        Dog d = (Dog)a;
        // d.lookHome(); // 异常提示 classCastException error 提示 // 猫不能被转成狗
    }
}




public class duotai1 {
}
