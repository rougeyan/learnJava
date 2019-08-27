package src.colletction;
import java.util.ArrayList;
import java.util.Collection;

/**
 *  collection
 *  存储容器不确定的, 需要容器,无法使用数组
 *
 *  数组的长度是固定的;
 *  集合的长度是可变的;
 *
 *  数组中储存的的是同一类型元素,可以存储基本,可以存储基本数据类型;
 *
 *  集合存储的都是对象,而且对象的类型可以不一致
 *  集合框架:
 *
 *  https://www.cnblogs.com/bingyimeiling/p/10255037.html
 *
 *  什么时候使用集合;
 *
 *  collection接口
 *
 *  因为数据结构的不一样;
 */
public class collection {
    public static void main(String[] args) {
        Collection coll = new ArrayList(); // 不关系子类对象是什么; // 向上转型;提高拓展性,隐藏子类型;使用的都是父类接口方法;
        collectionDemo(coll);
    }
    public static void collectionDemo(Collection c){
        // 往集合中添加对象元素 add(Object)
        c.add("itcast1");
        c.add("itcast2");
        c.add("itcast3");
        System.out.println(c);
        // 删除 remove()
        c.remove("itcast2");
        System.out.println(c);

        // 判定是否包含
        System.out.println(c.contains("itcast3"));

        // c.clear();

        // 带All的方法:
        // 具体查api

        // c.addAll(c2)
        // 删除不同的c1 和查相同的元素
        // c.removeAll(c2)
        // 保留相同
        // c.retainAll()
    }
}
