package src.fanxing;

import java.util.*;

/**
 * 泛型6 通配符
 */
class person implements Comparable<person>{
    private String name;
    private int age;

    public person() {
        super();
    }

    public person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(person o) {
        int temp = this.age - o.age;
        return temp ==0?this.name.compareTo(o.name):temp;
    }
}

// 子类学生
class Student extends person{
    public Student() {
        super();
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
// Worker
class Worker extends person{
    public Worker() {
    }

    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}



/**
 * 泛型通配符
 */
public class fanxing6tongpeifu {
    public static void main(String[] args) {
        // 哈希结构
        Set<Student> hashls = new HashSet<Student>();
        hashls.add(new Student("Studentl7",14));
        hashls.add(new Student("Studentl7z1",15));
        hashls.add(new Student("Studentl7w3",16));
        printlist(hashls);

        // List结构
        List<String>  stringls = new ArrayList<String>();
        stringls.add(new String("strl4"));
        stringls.add(new String("strz3"));
        stringls.add(new String("strw5"));
        printlist(stringls);

        List<Worker>  workerls = new ArrayList<Worker>();
        workerls.add(new Worker("workderl4",13));
        workerls.add(new Worker("workderz3",14));
        workerls.add(new Worker("workderw5",16));
        printlist(workerls);
    }

    /**
     *  重构成函数
     *  勾选右键  refactor => extract =>methods
     *  抽取成collection 类
     *  使用通配符
     *
     *  当使用泛型类或者接口时, 传递的的类型不确定 可以使用通配符(?)表示;
     *
     *  Collection<?> 可以穿任意类型
     *
     *  但是需求只允许部分类型
     *
     *  对集合元素传入的类型进行限定,
     *  使用泛型的限定,
     *  <? extends person> 接受person类 / person的子类; 上限
     *  总结
     *
     *  <? super E> 接受E类型或者E的父类型 下限
     *  E是固定的 上面的爹是可以换的;
     *
     *  <? extends E> 接受E类型 或者E的子类型; 上限
     *  E是固定的 下面的子类是可以换的;
     *
     */
    private static void printlist(Collection<?> e) {
        for (Iterator<?> iterator = e.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * 泛型的限定
 */
