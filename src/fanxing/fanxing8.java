package src.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import src.fanxing.person;

/**
 *  泛型的细节: 保证左右类型一致;
 *
 *  泛型应用:
 *   案例: 获取集合中元素的最大值;
 *   1.定义变量记录每次比较后的 max指,初始化元素中任意一个
 *   2. 遍历容器
 *   3. 在遍历中和遍历记录的元素进行比较,把最大值记录到变量中;
 */
public class fanxing8 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(new person("z3",13));
        c1.add(new person("w4",13));

        Student stu = getMax(c1);
        System.out.println(stu);
    }
    public static Student getMax(Collection e){
        // 1.定义变量,记录集中任意一个元素,collection 集合取出元素方式只有迭代器;
        Iterator it =e.iterator();
        Student maxvalue = (Student)it.next();
        // 2.遍历容器
        while (it.hasNext()){
            Student temp = (Student)it.next();// 强转类型;
            if(temp.compareTo(maxvalue)>0){
                maxvalue = temp;
            }
        }
    }
}
