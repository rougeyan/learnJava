package src.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import src.fanxing.Student;

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
    }
    // T 需要不需要做限定

    /**
     *
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
