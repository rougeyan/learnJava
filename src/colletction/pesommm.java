package src.colletction;

import java.util.Objects;

public class pesommm implements Comparable{
    private  String  name;
    private  int  age;

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

    public pesommm(String name) {
        this.name = name;
    }

    public pesommm(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "pesommm{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj){
//            return true;
//        }
//        System.out.println(obj instanceof pesommm);
//        if(!(obj instanceof pesommm)){
//            throw new ClassCastException("类型错误");
//        }
//        pesommm p = (pesommm)obj;
//        return this.equals(p.name) && this.age ==p.age;
//    }

    // 重写 hasCode() 方法;
//    @Override
//    public int hashCode() {
//        /**
//         * return 1
//         * hasCode冲突 然后判定equals equals不同就拉链
//         * 相同的时候每次判定equals 效率低
//         * 解决方法:
//         *  算法;
//         */
//        System.out.println("hasCode()"+name.hashCode());
//        return name.hashCode() +age*21;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pesommm pesommm = (pesommm) o;
        return age == pesommm.age &&
                Objects.equals(name, pesommm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof pesommm)){
            throw new ClassCastException("错误类型");
        }
        pesommm s = (pesommm)o;
//        if(this.age>s.age){
//            return 1;
//        }else if(this.age<s.age){
//            return -1;
//        }else{
//            return 0;
//        }
        /**
         * 比较时候明确主次;
         * 如果主要条件相同;
         *
         */
        int temp  = this.age - s.age;;
        // 字符串compareTo方法;
        return temp ==0?this.name.compareTo(s.name):temp;
    }


    //默认的comparetor


    // 集合中重复的概念: 判断依据:
    // 重复 一个对象添加两次 因此是重复;
    // 添加一个地址两次;    元素相同 == 对象相同 即
    // 判定元素相同 即equals;
    // 重复的概念: 即可 内存地址只想同一个
    // 但是重复我们的概念也可以自定义 某两个属性相同也可以视为重复;
}
