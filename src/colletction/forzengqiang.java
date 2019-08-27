package src.colletction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 循环增强
 * foreach
 */
public class forzengqiang {
    public static void main(String[] args) {
        /**
         * for (数据类型 变量 : collection集合 / 数组) {
         *             //  todo Something
         *
         *         }
         */
        // 过去写法 迭代器
//        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ) {
//            Object next =  iterator.next();
//
//        }
        List ls =  new ArrayList();
        ls.add("haha");
        ls.add("nba");
        ls.add("3214");
        ls.add("smgui");
        /**
         *  简化书写;对对象
         *  但是在元素之中做增删改;
         *  通常只作遍历元素 不能做操作;
         *
         *  与旧for循环有什么区别
         *  注意: 新for循环必须有被遍历的目标; 集合/数组
         *
         *  单纯遍历: 使用增强for
         *  老式for循环 具备角标操作;
         */
        for (Object s: ls) {
            System.out.println(s);
        }

    }
}
