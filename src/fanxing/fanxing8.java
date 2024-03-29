package src.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
//    1.最基础的版本;
//    public static void main(String[] args) {
//        Collection c1 = new ArrayList();
//        c1.add(new Student("z3",13));
//        c1.add(new Student("w4",17));
//        c1.add(new Student("k5",21));
//        c1.add(new Student("h7",19));
//
//        Student stu = getMax(c1);
//        System.out.println(stu);
//    }
//    public static Student getMax(Collection e){
//        // 1.定义变量,记录集中任意一个元素,collection 集合取出元素方式只有迭代器;
//        Iterator it =e.iterator();
//        Student max = (Student)it.next();
//        // 2.遍历容器
//        while (it.hasNext()){
//            Student temp = (Student)it.next();// 强转类型;
//            if(temp.compareTo(max)>0){
//                max = temp;
//            }
//        }
//        return max;
//    }
    // 2. 加入泛型
//        public static void main(String[] args) {
//        Collection<Student> c1 = new ArrayList<Student>();
//        c1.add(new Student("z3",13));
//        c1.add(new Student("w4",17));
//        c1.add(new Student("k5",21));
//        c1.add(new Student("h7",19));
//
//        Student stu = getMax(c1);
//        System.out.println(stu);
//    }
//    public static Student getMax(Collection<Student> e){
//        // 迭代器与容器一致
//        Iterator<Student> it =e.iterator();
//        Student max = it.next();
//        // 2.遍历容器
//        while (it.hasNext()){
//            Student temp = it.next();// 强转类型;
//            if(temp.compareTo(max)>0){
//                max = temp;
//            }
//        }
//        return max;
//    }

    // 3. (2)功能已经完成,但是仅限定student对象进行操作, 需要扩展到worker

    // 3-1. 要操作的类型确定吗? 不确定 使用泛型限定:
    // 不加泛型时,无法明确集合中的元素是什么类型,为了方便操作只能使用Object
//    public static void main(String[] args) {
//        Collection c1 = new ArrayList();
//        c1.add(new Student("z3",13));
//        c1.add(new Student("w4",17));
//        c1.add(new Student("k5",21));
//        c1.add(new Student("h7",19));
////        c1.add(new Dog()); error;
//
//        Student stu = (Student)getMax(c1);
//        System.out.println(stu);
//    }
//    public static Object getMax(Collection<Student> e){
//        // 迭代器与容器一致
//        Iterator<Student> it =e.iterator();
//        Object max = it.next();
//        // 2.遍历容器
//        while (it.hasNext()){
//            Object o = it.next();// 强转类型;
//            Comparable temp = (Comparable) o;
//            if(temp.compareTo(max)>0){
//                max = temp;
//            }
//        }
//        return max;
//    }


    /**
     * https://www.cnblogs.com/coprince/p/8603492.html
     * 泛型类; 泛型方法; 泛型接口; 最全解析;
     */
    // 3-2-1. 加入泛型
//    public static void main(String[] args) {
//        Collection<Student> c1 = new ArrayList<Student>();
//        c1.add(new Student("z3",13));
//        c1.add(new Student("w4",17));
//        c1.add(new Student("k5",21));
//        c1.add(new Student("h7",19));
////        c1.add(new Dog()); error;
//
//        Student stu = (Student)getMax(c1);
//        System.out.println(stu);
//    }
//    // T 需要不需要做限定
//    public static <T> T getMax(Collection<T> e){
//        // 迭代器与容器一致
//        Iterator<T> it =e.iterator();
//        T max = it.next();
//        // 2.遍历容器
//        while (it.hasNext()){
//            T o = it.next();// 强转类型;
//            Comparable<T> temp = (Comparable<T>) o;
//            if(temp.compareTo(max)>0){
//                max = temp;
//            }
//        }
//        return max;
//    }
// 3.2-2最终版本
    public static void main(String[] args) {
        Collection<Student> c1 = new ArrayList<Student>();
        c1.add(new Student("z3",13));
        c1.add(new Student("w4",17));
        c1.add(new Student("k5",21));
        c1.add(new Student("h7",19));
//        c1.add(new Dog()); error;

        Student stu = (Student)getMax(c1);
        System.out.println(stu);


        Collection<String> c2 = new ArrayList<String>();
        c2.add("haha");
        c2.add("smgui");
        c2.add("nba");
        c2.add("smguidiaodongxi");

        String str = (String) getMax(c2);
        System.out.println(str);

        // 当年没做泛型限定的时候可以传入任意的集合
        // 只有在在运行时候才会挂掉;
        // 现在是我已明确此功能中 集合没有错
        // T必须是Comparabale
        // 不具备自然排序的对象 传不进来;
        // 已经做了限定, 说明传递的元素类型必须是Comparable的子类;
        // 否则编译失败;
        // Collection<Dog> c3= new ArrayList<Dog>()
//        getMax(c3)
        //
    }
    // T 需要不需要做限定

    /**
     * 解析: https://blog.csdn.net/qq_35580883/article/details/78627756
     *
     * 最关键的是传入的T类型必须已经是实现了 Comparable接口 (接口接口) 中compareTo()这个方法。
     *                  类型                           返回值     入参;
     * public static <T extends Comparable<? super T>> T getMax(Collection<? extends T > e){
     */

    public static <T extends Comparable<? super T>> T getMax(Collection<? extends T > e){
        // 迭代器与容器一致
        Iterator<? extends T> it =e.iterator();
        T max = it.next();
        // 2.遍历容器
        while (it.hasNext()){
            T temp = it.next();// 强转类型;
            if(temp.compareTo(max)>0){
                max = temp;
            }
        }
        return max;
    }

}
