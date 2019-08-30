package src.cmap;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map 常见子类
 *  1.Hashtable 数据结构: 哈希表,不允许使用null作为键和值
 *      1-1: properties(常用) 属性值: key 和value 都是字符串,可以结合流进行键值操作 IO流;
 *  2.HashMap(常用) 数据结构: 哈希表,不是同步的 允许null作为键和值
 *      2-1: LinkedHashMap(常用): 基于链表+哈希表 可以保证map集合有序(存入和取出顺序一致)
 *  3.TreeMap(常用) 二叉树结构 不是同步的; 可以对map集合中的键进行排序;
 */
public class map2 {
    /**
     * HashMap储存自定义键值
     * 练习一: 姓名,年龄都有自己的归属地 对印关系
     * 学生对象和归属地
     */
    public static void main(String[] args) {
//        1. 创建集合对象
        Map<Student,String> map = new HashMap<Student,String>();  //无序;
        // Map<Student,String> map = new LinkedHashMap<Student,String>(); // 有序;
//        2.添加元素
        map.put(new Student("z3",19),"上海");
        map.put(new Student("l4",20),"北京");
        map.put(new Student("w5",21),"成都");
        map.put(new Student("h6",29),"广州");
        map.put(new Student("h6",29),"石家庄");
        map.put(new Student("k7",17),"广州");
        /**
         * 注意同姓名,同年龄应该视为重复key ,此时进入personn 重写hashCode() 和equals();
         */
//        3. 取出元素 ketSet(), entrySet();
//        Set<Student> keySet = map.keySet();
//        for(Student key: keySet)
        for(Student key: map.keySet()){
            String value = map.get(key);
            System.out.println(key.toString()+"+++"+value);;
        }

        /**
         * HashSet 单列集合
         * HashMap 双列集合
         */

    }
}

