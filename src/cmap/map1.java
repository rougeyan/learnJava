package src.cmap;

import java.util.*;
import java.util.Collections;

/**
 * map集合
 * 有对应关系的
 * 0-星期一;
 * 1-星期二
 * ...
 * 有对应关系,对应关系一方是有序的数字,可以使用数字作为角标,
 */
public class map1 {
    public static void main(String[] args) {
        String weekday = getWeek(1);
        System.out.println(weekday);;

    }
    public static String getWeek(int num){
        if(num<0 || num>7){
            throw new ClassCastException(num+ "没有对应星期");
        }
        String [] weeks ={"星期一","星期二"}; //  一张表 记录对应关系 换成集合List
        return weeks[num];
    }
}
/**
 * 新需求
 * 星期一 ---> Monday
 * 星期二 ---> Sunday
 *
 * 解决中英对应问题 可以通过两个List 来完成
 * int index = listcn.indexOf("星期一")
 * listen.get(index)
 *
 * 前提,保证中英文角标对应一致;
 * Collection只能存一个对象,希望有一一对应关系都存进去,便于操作
 *
 * 使用Map集合:
 * Map集合特点 都是 key=>value
 * 1. 内部存储的都是键值对
 * 2. 必须保证键的唯一性
 *
 * 无非都是存和取 一次存一对,
 * get(key)
 * put(key,value)
 */

class mapdemo{
    public static void main(String[] args) {
        Map<String,String> map= new HashMap<String,String>();

        // 添加元素;
        System.out.println(map.put("星期一","Monday"));
        System.out.println(map.put("星期二","Tuesday"));
        System.out.println(map.put("星期三","Wednesday"));
        System.out.println(map.put("星期四","Thursday"));
        System.out.println(map.put("星期五","Friday"));
        System.out.println(map.put("星期六","Saturday"));

        System.out.println(map.put("星期一","Mon")); // 如果键相同,值覆盖put方法 返回旧值, 没有值则为NULL
        map.put("星期日","sunday");
        System.out.println(map);

        // 通过指定键获取值;
        String value = map.get("星期日"); //// 如果不存在返回null,通过null判断键是否存在
        System.out.println("value="+value);
        // 根据键删value;
        String delvalue = map.remove("星期一");

        System.out.println(delvalue); // 顺带把键值对全删除;

        System.out.println(map);

        /**
         * keySet
         *  获取所有的键输出:
         *  返回集合, set单例集合
         *  获取map集合中的set集合
         *  获取key 的set集合;
         */
        System.out.println("======= keySet =======");
        Set<String> keySet = map.keySet();
        // 迭代器
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); ) {
            String key =  iterator.next(); // 获取键;
            String keyvalue = map.get(key);
            System.out.println("key:"+key+"  value:"+keyvalue);
            
        }
        // foreach循环遍历
            for (String key: keySet) {
                System.out.println(key+":"+map.get(key));

        }

        /**
         * Set entrySet()
         * 把map集合中的映射关系存储到set集合中
         * 映射关系: 只是把键和值的
         */
        System.out.println("======= entrySet() =======");
        Set<Map.Entry<String,String>> entry = map.entrySet();
        for (Iterator<Map.Entry<String, String>> iterator = entry.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> next =  iterator.next();
            // 获取键
            String entrySetkey = next.getKey();
            String entrySetvalue = next.getValue();
            System.out.println(entrySetkey+":"+entrySetvalue);
        }
        /**
         * map 集合没有迭代器, 取出元素的方式: 将map集合转成单列集合, 在使用单列集合的迭代器就可以了;
         * map 集合也不能直接被foreach 循环遍历(foreach循环以来迭代器)
         * Map.Entry => 接口中的接口 => 内部接口
         * entrySet() 打包key和value, 类型是Map.Entry类型;
         */


        System.out.println("======= 获取所有值的方法 values() =======");
        /**
         *  values() 返回的是一个Collection视图; 拿值 值不一定是唯一性;
         *  张三 = 北京
         *  李四 = 北京
         */
        Collection<String> values = map.values();
        for (String v: values) {
            System.out.println("value:"+v);
            
        }
        /**
         * 拿所有的键: keySet() get();
         * 拿所有的值: values() values();
         * 拿所有键值对: entrySet(); getKey(),getvalue()
         */
    }
}

// 接口中的接口;
//interface  mymap{
// 先有
//    public static interface MyEntrance{} // 内部接口;
//}

