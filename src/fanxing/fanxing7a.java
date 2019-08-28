package src.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 泛型限定在api的应用;
 */
public class fanxing7a {
    public static void main(String[] args) {
        /**
         *  TreeSet(Collection<? extends E> c) 上限
         *
         *  TreeSet(Comparator<? super E> comparator) 下限
         */

        Collection<Student> c= new ArrayList<Student>(
                // new ComparatorByName() 以来与比较器的比较
                // 因此可以
        );
        c.add(new Student("旺财1",26));
        c.add(new Student("Student旺财2",22));
        c.add(new Student("Student旺财3",23));

        /*TreeSet集合在创建时就将c中存储到TreeSet集合中*/
        /**
         *
         * class TreeSet<E>{  //person类型
         *     TreeSet(Collection<? super Students> c){  // 你是person我是person  你是person 我可以是student
         *     TreeSet(Collection<? extends person> c){  // 你是person我是person  你是person 我可以是student
         *         // 别的集合元素到底是什么类型
         *         // 传参的时候也是 person类型;
         *         // 也有可能是其他类型
         *         // 是student类型 继承制person类型的话
         *     }
         * }
         */
        TreeSet<person> ts = new TreeSet<person>(c);
        /**
         * 源码中 加入treeSet 传参是一个集合的话 是addAll()
         */
        ts.add(new person("lisi",98));

        for (Iterator<person> iterator = ts.iterator(); iterator.hasNext(); ) {
            person next = iterator.next();
            System.out.println(next);
        }

    }
}
