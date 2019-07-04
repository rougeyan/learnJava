//饿汉式 一上来就占用了内存(开发使用最多)
class SingleDemoo{
    public static void main(String[] args){
        // Single ss = Single.s // 可以实现,但是不提倡, 一般都是加入方法来获取为了对象可控;
        // Single ss2 = Single.getInstance()
    }
}
//饿汉式 一上来就占用了内存(开发使用最多)
class Single{
    // 私有; // final 更加严谨;
    private  static /*final*/ Single s = new Single(); // 成员变量
    private Single(){
    }
    public static Single getInstance(int x){ // 成员变量  属性私有化,对外提供方法; // 这里single 已经创建了对象;
//        if(x<0)
////            return null;  // 方法可控;
        return s;
    }
}

// 懒汉式(面试最多) 延迟加载;
class Single2{
    // 定义类 类型s2
    private static Single2 s2 =null;
    // 构造函数
    private Single2 (){
    }
    // 若无则加载
    public static Single2 getInstance(){
        // 多线程是有问题;
        if (s2 ==null)
            s2 = new Single2();
            return s2;
    }
}


// 应用
class Superman{
    private String  name;
    private static Superman man = new Superman("克拉克"); //单例

    Superman(String name){
        this.name = name;
    }
    public static Superman getInstance(){ // 单例
        return man;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getName(){
        return this.name;
    }
    public void fly(){
        System.out.println(this.name+"..fly");
    }
}

class SupermanTest{
    public static void main(String[] args){
//        Superman man = new Superman("克拉克");
//        Superman man = new Superman("克拉克"); 这样会撞车;
//        man.fly();
        Superman man1 = Superman.getInstance();
        Superman man2 = Superman.getInstance();
        man1.setName("hero");
        man2.fly();
    }
}