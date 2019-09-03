package src.colletction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * listIterator
 * 允许在迭代的过程中 对元素进行操作;
 */

public class collection4ListIterator {
    public static void main(String[] args) {
        List ls = new ArrayList();
        ls.add("itcast1");
        ls.add("itcast2");
        ls.add("itcast3");
        ls.add("itcast4");
//        Iterator haha = ls.iterator();

        ListIterator haha = ls.listIterator();
        while(haha.hasNext()){
            // 相同对象的时候加入增删改查;
            Object obj = haha.next();
            if("itcast2".equals(obj)){
//                haha.add("java2");
                haha.set("java");
            }
        }
        System.out.println(ls);
        /**
         * 迭代的时候不允许修改
         *
         * Iterator有一个子接口 是listIterator
         *
         * ListIterator haha = ls.listIterator();
         *
         * 该列表迭代器只有list接口有
         *
         * 而且该迭代器能在迭代过程中进行增删改查动作;
         *
         * List 下常见的子类对象
         * 开发中常用
         * ArrayList
         * LinkedList
         * Vector
         *
         */
    }
}
