package src.fanxing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fanxing1 {
    public static void main(String[] args) {
        /**
         * 为了使集合使用更加安全,
         * 问题: 什么类型的元素都能够存储,导出取出时出现强转引发 classCastException,
         * 在创建集合之前 明确元素类型
         *
         * 解决方案: 使用容器,明确容器中的元素的类型, 即泛型;
         * List<类型>
         *     1. 安全机制
         *     2. 把运行时的ClassCastException
         *     3. 泛型机制, 是编译器使用的技术;
         *     4. 避免了强转类型的的麻烦
         * List<String> ls = new ArrayList();
         * 创建集合时明确要存储在的元素类型, 编译器检查报错;
         * 把运行时的问题转到编译时期;
         *
         *
         * 泛型的擦除: 生成的文件不带泛型;
         *
         *
         *
         */
        // int[] arr = new int[]
        List<String> ls = new ArrayList();
        ls.add("abc");
//        ls.add(5);
        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
//            Object next = (Object) iterator.next();
//            System.out.println(next);
            String next = (String) iterator.next();
            System.out.println(next); //error java.lang.Integer cannot be cast to java.lang.String
        }
        /**
         * 集合中存在多存类型 怎么解决?
         *
         */
    }
}

//  泛型参数 E是参数; 都是类名 首字母大写;
class add<E> {
    void add(int x){

    }
}