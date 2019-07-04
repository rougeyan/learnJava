package jicheng;

// 面向对象的另外一个特征: 继承;
// 提高代码复用性, 让类与类产生关系
// 给另外一个特称 多态 提供前提;
// 单继承  - 多继承 - 多重继承;

// 什么时候定义继承
// 必须保证类与类之间有所属(is a)关系
// 苹果 =水果 , 狗=>犬类

// java 中继承的体现
// java 允许单继承, 不直接多继承, 多继承以其他方式体现
// 单继承: 一个子类只能有一个父类
// 多继承: 一个子类只能可以有多个父类
// 多继承(注意:): 父类若有相同方法 / 属性 会产生调用的不确定性,

// 多重继承 a=>b =>c;
class Person {
    String name;
    int age;
}
class Student extends Person{
    void study(){
        System.out.println(name+age+" good good study");
    }
}

class Workder extends Person{
    void work(){
        System.out.println("hard work");
    }
}

class ExtendsDemo{
    public static  void  main(String[] args){
        Student stu = new Student();
        stu.name = "xiaoming";
        stu.age =12;
        stu.study();
    }
}
