package src.fanxing;

import java.util.*;

/**
 * 集合工具类
 */

class comparetorByLenth implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        int temp = o1.length() - o2.length();
        return temp ==0?o1.compareTo(o2):temp;
    }
}

public class fanxing9 {
    public static void main(String[] args) {
        /**
         *  Collection: 集合框架中用于操作集合对象工具类
         *  都是静态方法
         *  1. 获取最值
         *  2. 对list集合派和,也可以二分查找
         *  3. 对排序逆序
         *  4. 可以将非同步的集合转成同步的集合
         *  XXX synchronized   List synchronized(List) 异步容器;
         */
        System.out.println("====== 获取最值 ========");
        Collection<String> c = new ArrayList<String>();
        c.add("haha");
        c.add("zzz");
        c.add("gogo");
        c.add("php");
        String max = Collections.max(c);
        System.out.println(max);;

        System.out.println("====== 排序  按照比较器来输出========");
        List<String> cc = new ArrayList<String>();
        cc.add("hahahah");
        cc.add("zz");
        cc.add("gogog");
        cc.add("phph");
        cc.add("abc");
        Collections.sort(cc,new comparetorByLenth());
        System.out.println(cc);

        System.out.println("====== 排序反序 ========");
        Collections.sort(cc,Collections.reverseOrder(new comparetorByLenth()));
        System.out.println(cc);


        System.out.println("====== 获取最值 ========");
        System.out.println("====== 获取最值 ========");
        System.out.println("====== 获取最值 ========");

    }
}
