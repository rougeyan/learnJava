package src.fanxing;

import java.util.*;

class person {
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
     */
    private static void printlist(Collection<?> e) {
        for (Iterator<?> iterator = e.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
