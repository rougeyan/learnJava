package src.learnPacket;

//package mypackage.aa.bb

//package

//set classpath = d:\mycalss

/**
 * 单个目录下只能存在一个同名的包;
 * 对与多个类,为了便于管理(类的同名情况),所以java提供了一个方法
 * 包机制,落实到操作系统,就是文件夹,对与java 就是包
 *
 * 作用
 * 1.对类文件进行管理,
 * 2.给类文件提供命名空间,
 * 包的定义
 * package 包名 (包名中所有字母都是小写)
 * 有所属空间,
 * 命名空间
 */
public class packet1 {
    public static void main(String[] args) {
        System.out.println("这是一个包");
    }
}
/**
 * 包与包之间的类的访问时,
 * 被访问的类以及成员都必须public修饰
 *
 * 注意事项被public修饰的类/接口, 所属的java文件名 必须和类或者接口名称一致;
 */
