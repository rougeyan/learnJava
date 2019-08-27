package src.colletction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * set
 * 子集合
 *  HashSet(); 哈希表;散列; 元素=>哈希对应关系; 查询速度比数组快; 重复元素存不进去,保证元素唯一性;
 *      如果元素hasCode()一致 会出现:哈希冲突;
 *      元素内容是否一致equals();
 *      功能算法:
 *      如果equals返回true 以为着两个元素相同, 不存;
 *      如果equals返回false, 两个元素不相同, 存, 继续通过算法 计算位置; 拉链法(本位置上的下一个)
 *  TreeSet();
 */

public class collection5set {
    public static void main(String[] args) {
        Set s = new HashSet();
        // 取出了字符串中的重复元素
//        s.add("itcast");
//        s.add("nba");
//        s.add("java");
//        s.add("haha");
//        s.add("3");
//        s.add("7");
//        s.add("9");
//        s.add("20");
//        s.add("haha");
//        s.add("haha");
//        s.add("haha");
        s.add(new pesommm("z3",13));
        /**
         *  为什么学生对象的没有保证唯一性呢?
         *  通过哈希表的分析;
         *  存储元素时候,先调用了了元素的hasCode()方法;
         *  而每个元素都是新建的new 对象,
         *  所以hasCode 的值就不同了, 也就不需要equals了;
         *
         *  调用hasCode放,每一个新建的对象都有自己的哈希值此时就不管内容一致不一致;
         *
         *  如果解决:
         *
         *  重写hasCode()方法;
         *
         */

        s.add(new pesommm("z3",13));
        s.add(new pesommm("z3",13));
        s.add(new pesommm("l4",32));
        s.add(new pesommm("l4",18));
        s.add(new pesommm("w5",33));

        for (Iterator iterator = s.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }


        /**
         * 演示TreeSet
         *
         * TreeSet的add方法,内部最终实现,
         * 需要将元素最终转化成comparable类型,
         * 此类型可以转化成可排序的能力,
         * 提供一个专门为排序提供的compareTo方法:
         *
         * 如果让学生具备排序功能,需要扩展学生的功能,实现comparable接口;
         */
        // 在创建对象TreeSet的对象时候 传入比较器实例
        Set setter = new TreeSet(new CompartorByName());
        setter.add(new pesommm("z4",99));
        setter.add(new pesommm("z6",32));
        setter.add(new pesommm("z8",9));
        setter.add(new pesommm("z2",12));
        setter.add(new pesommm("z87",12));
        for (Iterator iterator = setter.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
