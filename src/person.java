class Person{
    private String name;
    private int age; // 因为设置了private 不能再person类以外的程序直接访问;
    // 对变量分别是 set / get 操作


    // 构造函数, 给予默认值; 新建的时候会给予默认值;
    // 构造函数细节:
    // 1. 一个类中可以有多个构造函数,他们存在的方式是以重载的形式体现的;
    // 2. 构造函数中也是有return 语句的, 用于结束初始化动作;
    // 3  构造函数能private修饰; 但是其他程序无法创建创建该类的对象;(意义不大) 在本类里面创建;
//    class person{
//        private person(){
//
//        }
//    }
//    main(){
//        person p = new Person(); // 错误
//    }

    Person(){

    }
    Person(int a){
        if (a<30)return;
        age = a;
    }
    Person(String n){
        name = n;
    }

    // 一般函数还是需要的 能够通过set / get 修改属性;
    // 构造函数仅调用一次, 一般方法能够被调用多次;
    // 类中不需要对外提供的内容都私有化,包含属性和行为

//    构造函数使用大写;一般方法使用小写
    void speak(){
        System.out.println("age="+age);
        System.out.println("age="+age);
    }
    // set 操作
    void setAge(int a){
        if(a>0 && a<100){
            age= a;
        }else{
            throw new RuntimeException("sorry");
        }
    }
    // get 操作
    int getAge(){
       return  age;
    }
    // this关键字区分成员变量 / 局部变量;
}

class PersonDemo{
    public static void main(String[] args){
        Person d = new Person();
        Person p = new Person("xiaoming");
        // 即使没有定义构造函数, 只有定义要给类,默认就有一个空参数的构造函数;
        p.setAge(20);
        int a  = p.getAge();
        System.out.println(a);
    }
}