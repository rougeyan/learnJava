package src.fanxing;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 通配符在api的应用,
 *
 * 泛型限定在api的应用;
 */
public class fanxing7 {
    public static void main(String[] args) {
        /**
         * 通配符在api的应用
         */
        Collection<String> c1 = new ArrayList<String>();
        ((ArrayList<String>) c1).add("haha");
        ((ArrayList<String>) c1).add("xixi");
        Collection<String> c2 = new ArrayList<String>();
        ((ArrayList<String>) c2).add("haha");
        ((ArrayList<String>) c2).add("xixi");

        // 判定包含关系;
        boolean b = c1.containsAll(c2); // 了解containsAll 源码类的依据 // 依据是equals方法, equals的方法定义
        /**
         * containsAll 是任意类型的都可以;
         * 不明确类型的的情况下传参 直接传 <?>;
         */
        System.out.println("B="+b);

        //
    }
}
/**
 * class methodss<E> {
 *     public boolean containsAll(methodss<?> c){
 *        参数中使用methodss<E>
 *        为什么是<E>;
 *        创建判定是String的话 我要判定包含的也应该是String;
 *        创建Person 也应该判定传入的是Person
 *     }
 * }
 */
