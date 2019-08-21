package src.lei;

class constor {
// 1.加载demo.class文件进入方法区, 进行空间分配
// 2. 如果有静态变量, 先默认初始化, 显示初始化,
// 3. 如果有静态代码块, 要执行, 仅一次
// 4. 通过new 在堆内存中开辟空间, 并明确首地址
// 5.对 对象中的属性进行默认初始化,
// 6. 调用和对象的构造函数进行初始化
// 7. 构造函数内部
//  7.1调用构造函数super()
//  7.2 成员变量的显示初始化
//  7.3 构造代码块 初始化
//  7.4 构造函数内容自定义内容初始化
// 8.对象初始化完毕,将地址赋值给d引用变量

    // 构造代码块
    // 只要创建对象就会被调用; 给所有对象初始化; 构造函数只给对应的对象针对性的初始化;
    static int x =1; // 静态变量
    int y=2;
    static { // 静态代码块
        // 静态比它先执行;
        // 定义不同构造函数的共性代码
        // static 只能访问static;
        System.out.println("静态x是"+x);
        // 错误
        // System.out.println(y);
    }
    {
        // 未建对象前执行的代码块;
        System.out.println("打印首先定义的的y是"+y);
    }
    constor(){
//        System.out.println("此时执行了构造函数");
    }
    constor(int n){
        System.out.println("此时执行了构造函数");
//        错误 haha未定义;
//        this.haha = x;
        System.out.println("未改变前打印x="+this.x);
        System.out.println("未改变前打印y="+this.y);
        this.y =  n;
        System.out.println("修改y后打印"+this.y);
    }
}
class constructorCodeDemo{
    public static void  main(String[] args){
        constor b = new constor(5);
    }
}

