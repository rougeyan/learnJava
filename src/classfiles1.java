class Car{
    String color;
    int number;
    void  run(){
        System.out.println(color+":"+number);
    }
}
class cardemo{
    public static void  main(String[] args){
        // 类 类类型变相 一定指向对象;
        Car c = new Car();
        c.color="red";
        c.number = 4;
        c.run();
        show(new Car());

        // 匿名对象 为了简化书写;
        new Car().run();
        // 只调用一次;
    }
    public static void show(Car cc){
        cc.color="black";
        cc.number = 5;
        cc.run();
    }
}