package src.testPacket;

import src.learnPacket.*;

import src.*; // 不建议使用通配符; 索引麻烦;


/**
 *
 * import 导入的是包中的类 与包中的包没有关系;
 *  特殊情况2:
 * import packeta.*; // 不会导入packet下子包中的类
 * packeta\packetaa\demoAA.class
 *        \demoAA.class
 *
 *        new demoAA() // 此处使用的是demoAA.class  不是使用packetaa下的demoAA.class
 *
 * 如果你要使用packetaa
 * 要使用
 * import packeta.*;
 * import packeta.packetaa.*;
 *
 * 打包是打包 包中的类   包中的包不会被打包
 *
 *
 * 特殊情况2: 不同包中 相同名称的类
 *
 *  packeta\demo.class
 *  packetb\demo.class
 *
 *
 *  new demo(); // 错误
 *
 *  必须指定packet
 *  new packeta.demo();
 */

/**
 * 特殊情况一":
 */
public class testPacket {
    public static void main(String[] args) {
        // 要再添加路径;
        src.learnPacket.packet2 packetDemo =  new src.learnPacket.packet2();
        packetDemo.methods();
        System.out.println("packet");


        // 创建子类对象
        src.learnPacket.packet3 p3 = new src.learnPacket.packet3();
        p3.show();
        // 引用
        src.learnPacket.packetFu pfu = new src.learnPacket.packetFu();
        // pfu.showfu(); // 因为showfu 被protected了只有创建子类对象才能创建;
    }
}

/**
 * 包继承
 */