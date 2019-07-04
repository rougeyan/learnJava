package jicheng;

public class jicheng10 {
    public static void main(String[] args){
        Dtudents sss =  new Dtudents("lisi",4);
        sss.sayHellow();
        new WorkersBen("bens",24);
    }
}
class Persons{
    private String name;
    private int age;
    public Persons(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
class Dtudents extends Persons{
    // 构造函数
    public Dtudents(String name,int age){
        super(name,age);
    }
     public void sayHellow(){
        System.out.println("hello,my name is "+getName()+getAge()+"yearsold");
    }
}

class WorkersBen extends Persons{
    // 构造函数
    public WorkersBen(String name,int age){
        super(name,age);
    }
}