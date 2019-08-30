package src.cmap;

import java.util.Objects;

public class demoStudent {
}
class pesonn implements Comparable<pesonn>{
    private String name;
    private int age;

    public pesonn() {
        super();
    }

    public pesonn(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pesonn pesonn = (pesonn) o;
        return age == pesonn.age &&
                Objects.equals(name, pesonn.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(pesonn o) {
        int temp = this.age - o.age;
        return temp ==0?this.name.compareTo(o.name):temp;
    }
}

// 子类学生
class Student extends pesonn{
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
class Worker extends pesonn{
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