package src.duotai;

/**
 * 阶段一:
 *  笔记本 运行
 * 阶段二:
 *  扩展鼠标(多了个对象)
 *   行为:
 *      开启/关闭 .. 移动..点击..轨迹
 *  笔记本怎么使用鼠标呢?
 *   笔记本中多了一个鼠标的功能;
 *   即对笔记本重新描述, 需要修改笔记本类中的内容, 添加一个功能,叫
 * 阶段三:
 *  如果加入一个键盘呢?
 *  只要描述一个键盘类,并且在电脑类中加入一个功能;
 *
 *  问题来了,
 *  每次增加拓展 都要重复进入notebook 增加useXXX功能源码, 功能性差
 *
 *  class notebook{
 *     public void run(){
 *         System.out.println("notebook");
 *     }
 *     public void useMouse(mouse m){
 *         if(m != null){
 *             m.open();
 *             m.close();
 *         }
 *     }
 * }
 *
 * class mouse{
 *     public void open(){
 *         System.out.println("mouse open");
 *     }
 *     public void close(){
 *         System.out.println("mouse close");
 *     }
 * }
 * public class duotai4 {
 *     public static void main(String[] args) {
 *         notebook book = new notebook();
 *         book.run();
 *         book.useMouse(new mouse());
 *     }
 *
 * }
 *
 *  设计:改进
 *  问题在于外围设备的增加和笔记本之间的耦合性过高
 *
 *  定义一些规则, 外围设备只要使用规则即可;
 *
 *  只需要定义规则 我无需知道接口接入什么
 *
 *  只要设备符合这些规则就可以被笔记本实用
 *
 *  即可接口;
 */

// usb 定义
interface usb{
    void open();
    void close();
    // 功能是子类的事 主题无需关心

}

// 定义主体
class notebook{
    public void run(){
        System.out.println("notebook running");
    }
    // 使用usb接口的功能
    public void useUsb(usb a){  //接口类型变量, 接口类型的变量指向子类对象
                                // 其实该语法 跟 usb a = new usb() 是一样的道理 即多态;
                                // 给它定义了 类型;
        if(a != null){
            a.open();
            a.close();
        }
    }
}
// 定义外围设备 必须符合usb轨迹
class mouse implements usb{
    public void open() {
        System.out.println("mouse run");
    }
    public void close() {
        System.out.println("mouse close");
    }

}





public class duotai4 {
    public static void main(String[] args) {
        notebook book = new notebook();
        book.run();
        book.useUsb(null);
        book.useUsb(new mouse());
        // 反射可以避免重复使用 book.useUsb()
        // book.useUsb(new mouse()); ..
        // book.useUsb(new mouse()); ..
        // book.useUsb(new mouse()); ...
    }

}
