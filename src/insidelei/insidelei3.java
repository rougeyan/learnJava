package src.insidelei;

/**
 * 内部类的延伸; 类中的类
 * xxx.xxx 内部类
 * 内部类成为成员的时候 可以被static 修饰 内部类;
 * 内部类 / 内部接口 生成
 *
 * 看API 类型/ 接口中有 (.) 说明是内部类/内部接口
 *
 *  与其他的类/ 其他的接口产生关系;
 *
 *  内部类可以继承 / 实现 外部其他类 /接口;
 *  好处在于通过内部内的方式对类 进行重写 / 接口进行实现;
 *  通过公共的方式对其内部类对象进行访问
 *  因为内部类通常被外部类封装其中
 *  我们可以通过父类或者接口的方式访问到内部类对象
 */
public class insidelei3 {
    public static void main(String[] args) {
        outerc out = new outerc();
        out.methods();
        // 如果inner 对外提供,可以通过以下方式
        outerc.inner in = out.getObject();
        in.show();
        // 如果inner 被私有, 可以通过父类型获取

        // 内部类完全隐藏起来了;
        absDemo inn = out.getinnerObjects(); // 即多态;
        inn.show();
        // 编译看左边
        // 运行看右边
    }
}
abstract class absDemo{
    abstract void show();
}

class outerc{
    int num = 3;
    class inner extends absDemo{
        // 对抽象类的show方法进行了重写;
        void show(){
            System.out.println("num="+num);
        }
    }
    // 获取内部类的对象
    // 不对外暴露inner 对外暴露其父
    public inner getObject(){
        return new inner();
    }

    // 即多态 返回一个absDemo 类型的 new inner() 对象
    public absDemo getinnerObjects(){
        return new inner();
    }


    public void methods(){
        new inner().show();
    }
}

