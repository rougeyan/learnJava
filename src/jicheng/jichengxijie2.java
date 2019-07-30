package src.jicheng;

/**
 * 抽象类中是否可以不定义抽象方法
 * 答: 可以的 原因是不让该类创建对象
 */


interface inter{
    //  定义四中显示方法
    public void shou1();
    public void shou2();
    public void shou3();
    public void shou4();
}

class interimpl1 implements inter{
    @Override
    public void shou1() {
        System.out.println("show1 run");
    }
    // 但是不能创建对象 是因为接口有四个方法
    // 但是我只是重写了shou1
    // 其余四个方法没有被重新
    // 因此创建类失败;

    // 为了该类实例化,还需要覆盖其他三个方法
    // 单纯写方法即可;
    @Override
    public void shou2() {
        // 有方法体(实体)
        // 但是实体为空
    }

    @Override
    public void shou3() {

    }

    @Override
    public void shou4() {

    }
}

// 创建第二个类
class interimpl2 implements inter{
    @Override
    public void shou3() {
        System.out.println("show1 run");
    }
    // 但是不能创建对象 是因为接口有四个方法
    // 但是我只是重写了shou1
    // 其余四个方法没有被重新
    // 因此创建类失败;

    // 为了该类实例化,还需要覆盖其他三个方法
    // 单纯写方法即可;
    @Override
    public void shou2() {
        // 有方法体(实体)
        // 但是实体为空
    }

    @Override
    public void shou1() {

    }

    @Override
    public void shou4() {

    }
}
// 问题反馈

//为了使用接口中的部分方法,而覆盖了全部方法,而且每一个子类都这样做,复用性极差
// 解决方法: 将这些不用的方法都单独抽取到一个独立的类中
// 让这个类去实现接口, 并覆盖接口的所有方法



// interimpl3 这个类知道这些方法的具体实现内容吗?
// 答: 不知道,只能为了后期子类创建对象方便 而进行的 空实现;
// 而这时这个类创建对象有意义吗?
//  没有意义;
// 这个类创建对象就不需要, 直接将其抽象化;
//  添加 abstract 修饰符
// awt 体系有用到;
// 不能构造函数 私有变量 私有变量不能被继承
// 但是又需要继承;
abstract class interimpl3 implements inter{
    public void shou1() {

    }

    @Override
    public void shou2() {

    }

    @Override
    public void shou3() {

    }

    @Override
    public void shou4() {

    }
}

// 利用impl4 直接去继承 impl3(通过impl 实现 inter所有方法重写)
// interimpl3 实际上就是实现了抽象实现;

class interimpl4 extends interimpl3{
    @Override
    public void shou1() {
        System.out.println('shou1 run1');
    }
}
class interimpl5 extends interimpl3{
    @Override
    public void shou2() {
//        super.shou2();
        System.out.println('sho2 run2');
    }
}

public class jichengxijie2 {
}

