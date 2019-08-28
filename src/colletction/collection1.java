package src.colletction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 取集合中的单个元素
 *
 *  iterator
 *
 *  集合细节:
 *   1. 集合中存储的其实都是对象的地址;
 *   2. 集合中可以存储基本数值吗?
 *      答: 不可以,只能存对象; jdk在1.5版本之后实质是 储存基本数据类型包装类对象;
 *   3. 存储时候都是以Object对象作为存储类型,取出时,受用元素特有内容 需要向下转型;
 */
public class collection1 {
    public static void main(String[] args) {
        /**
         * 集合的取出方式:
         * 每个容器的数据结构的不一样 依赖于结构;
         * 取出方式 不通用 与数据结构以来;
         *
         * 每个取出方式 建立共性标准:
         * 取元素,无论是什么数据结构,最终共性的去处方式都是一个一个取,取之前先判断,有取一个,没有=>结束
         * 这种去处方式叫 迭代;
         *
         * 返回迭代器对象
         */
        // 1.创建集合对象
        Collection co = new ArrayList();
        co.add("itcast");
        co.add("haha");
        co.add("nba");
        co.add("tmac");
        System.out.println(co);

        // 2.获取容器迭代器  返回 Iterator

        // 不用再new对象, 因为是collection 中的 接口方法;
//        Iterator it = co.iterator();
//        System.out.println(it.next()); // 1
//        System.out.println(it.next()); // 2 自动取下一个;
//        System.out.println(it.next()); // 3
//        System.out.println(it.next()); // 4
//        System.out.println(it.next()); // NoSuchElementException

        // 3.使用具体的迭代器对象获取集合中的元素
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        // 实际开发
        for (Iterator it = co.iterator(); it.hasNext();) {
            // System.out.println(it.next());

            Object obj = it.next(); // 取出来的都是obj;
            //  需求: 获取长度, 向下转型
            // 需要使用元素的特有方式时需要向下转型;
            String str =(String)obj;

            System.out.println(obj);

            System.out.println(str.length());
        }
    }

}
