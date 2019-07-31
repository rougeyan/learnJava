package src.duotai;

class 毕姥爷{
    public void 讲课(){
        System.out.println("讲课");
    };
    public void 钓鱼(){
        System.out.println("钓鱼");
    };
}

class 毕老师 extends 毕姥爷{
    @Override
    public void 讲课() {
        System.out.println("授课 java");
    };

    public void 看电影() {
        System.out.println("看电影");
    };
}

public class duotai3 {
    public static void main(String[] args) {
        毕姥爷 x  = new 毕老师(); // 多态, 向上转型.
        x.讲课(); // 人没变, 只是伪装毕姥爷 本质还是本类对象;
        // 最终运行的是:  授课 java 覆盖了毕姥爷的方法;
        x.钓鱼(); // 可以 是因为 继承了父亲 用的父亲;
        // x.看电影(); // 不可以 因为毕姥爷没有这功能 虽然伪装了 但是毕姥爷没有这功能 会被识破;
        // 需要想法转型才能使用
        if(x instanceof 毕老师){
            毕老师 y = (毕老师)x;
            y.看电影(); // 可以的
            y.钓鱼();
        }

        // 支持至终都是 子类对象进行类型转换;
        // 毕老师佬转换类型

    }
}
