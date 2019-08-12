package src.insidelei;

public class insidelei5 {
}

interface Intera{
    void show();
    void show2();
}

class outerp{
    int num = 4;
//    class inner implements Intera{
//        public void show(){
//
//        };
//        public void show2(){
//
//        };
//    }
    public void method(){
//        inner in = new inner();
//        in.show();
//        in.show2();
        Intera in = new Intera(){  // 这里是多态 多态接口类型引用指向了接口的子类对象
            // 首先是(匿名)实现接口 重写Intera 然后创建(匿名)对象 => 使用多态 => 指定为Intera类;
            public void show(){

            }
            //
            public void show2(){

            }
        };
        in.show();
        in.show2();
    }
}