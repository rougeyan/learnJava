package src.fanxing;
// https://segmentfault.com/a/1190000014120746#articleHeader6
// https://blog.csdn.net/s10461/article/details/53941091

/**
 * 当方法操作的类型不确定的时候,
 * 应该吧泛型定义在方法上
 */

public class fanxing4 {
    public static void main(String[] args) {
        Utilss newUtils = new Utilss();
        newUtils.print(5);
        newUtils.print("15");
    }

}

/**
 * 泛型方法:
 * 把泛型定义在方法上而不是类上, 避免经常创建
 */
class Utilss /* Utilss<Q>*/{
    // 泛型的方法
    public <Q> void show(Q q) {
        System.out.println("show" + q);
    }

    public <Q> void print(Q q) {
        System.out.println("show" + q);

    }
}

/**
 *
 * 把泛型定义在类上
 * 泛型的类
 */
class Utilsssss<Q>{
    public void show(Q q) {
        System.out.println("show" + q);
    }

    public void print(Q q) {
        System.out.println("print" + q);

    }
    //  如果方法是静态的,还需要使用泛型,name泛型必须定义在方法上
    public static<E> void spellout(E e) {
        System.out.println("spellout" + e);

    }
}

/**
 * 泛型的接口
 */