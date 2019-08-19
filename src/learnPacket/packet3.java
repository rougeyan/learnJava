package src.learnPacket;

/**
 * 包继承
 *
 * 包与包访问的权限
 * public 就是谁都能用
 *
 * protected
 *
 * 专门给子类用
 * 别的权限用不了;
 *
 * 但是不给public 的话 只有通过创建子类对象才能使用
 *
 * 包与包之间的继承, 父类可以给其他包中的子类提供一种特殊的权限, protected  只有继承子类后,就可以访问权限
 *
 * 总结:
 *          public protected default private;
 * 一个类中    ok       ok       ok       ok
 * 一个包中    ok       ok       ok
 * 子类       ok       ok
 * 不同包中    ok
 *
 * 包与包之间访问只有两种权限 public 和protected(该权限只能给不同包的子类使用)
 */
public class packet3 extends src.learnPacket.packetFu{
    public void show(){
        showfu();
        System.out.println("showFu");
    }
}
