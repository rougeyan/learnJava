package src.jicheng;

/*
* 接口出现后的的部分细节
* 1.类与类之间及继承关系,类与接口是实现关系,(like a)关系
* 2/
* */
interface interfaceA{
    void show1();
}
interface  interfaceAA{
    void show11();
}
interface InterB extends interfaceA, interfaceAA{ // 接口支持多继承
    void show2();
}
// implements实现

class Test implements InterB{
    public void show1(){

    }
    public void show2(){

    }
    public void show11() {

    }
}
public class jichengxijie1 {
}
