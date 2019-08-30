package src.cmap;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class map3 {
    public static void main(String[] args) {
        /**
         * 练习二: 按照学生的年龄从小到大排序;
         */
//        1. 创建TreeMap集合对象
        Map<Student,String> map = new TreeMap<Student,String>(/*此处可以放比较器*/new ComparableByname());  //无序;
//        2.添加元素
        map.put(new Student("z3",123),"上海");
        map.put(new Student("l4",240),"北京");
        map.put(new Student("w5",211),"成都");
        map.put(new Student("h6",865),"广州");
        map.put(new Student("h6",229),"石家庄");
        map.put(new Student("k7",177),"广州");
//        3. 取出元素 ketSet(), entrySet();
        /**
         * 对学生进行排序 使用comparable接口
         */
        for(Map.Entry<Student,String> me: map.entrySet()){
            Student key = me.getKey();
            String value =  me.getValue();
            System.out.println(key+":"+value);
        }
        /**
         * 进阶练习二: 对学生按照姓名排序
         * 匿名内部类 /比较器 比较器放
         */

    }
}

class ComparableByname implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int temp  = o1.getName().compareTo(o2.getName());
        return temp ==0?o1.getAge()-o2.getAge():temp;
    }
}
