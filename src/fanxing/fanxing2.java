package src.fanxing;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *  泛型配合匿名内部类 减少转型;
 */

public class fanxing2 {
    public static void main(String[] args) {
        // 创建一个唯一性元素的集合要求排序;
        // 按照长度排序 需要比较器;
        // 使用匿名内部类完成;
        Set<String> s= new TreeSet<String>(new Comparator<String>() {
            // 指定 比较器;
            //匿名内部类
            // 传参数 的是确保参数的类型匹配;
            @Override
            public int compare(String o1, String o2) {
                int temp = o1.length() - o2.length();
                return temp==0?o1.compareTo(o2):temp;
            }
        });

        s.add("abdef");
        s.add("eeee");
        s.add("faf");
        s.add("6421");
        for (Iterator<String> iterator = s.iterator(); iterator.hasNext(); ) {
            // 因为传入的时候已经明确了是传入String类型的元素,因此不用再向下转型;
            String next = /**(String) */iterator.next();

            System.out.println(next);
        }
    }
}
