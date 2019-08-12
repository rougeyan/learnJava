package src.insidelei;

// 匿名内部类联系
public class inside5 {
    public static void main(String[] args) {
        // 匿名内部类;
        outere.method().show();
        // 还原为内部类;
        outere.methods().show();



        // outerd.method(): outer有一个method的方法 这个方法是静态的
        // outerd.method().show(); 能调用show() 说明返回的是一个对象
        // 能够调用inter的show方法 说明这个对象的类型是inter
    }
}

interface Intersss{
    public void show();
}
class outere{
    // 代码不足, 要求使用匿名内部类
    public static Intersss method(){
        // 既然在outer类中使用到inter的对象,可以使用内部类来完成;
        // 需要子类型 只要简化格式即可,因为接口中只有一个方法;
        return new Intersss(){
            public void show(){
                // todo something
            }
        };

    }
    // 还原为内部类
    // 静态方法不能访问内部类; 需要 加入static作为修饰符
    static class innersss implements Intersss{
        @Override
        public void show() {

        }
    }
    public static innersss methods(){
        return new innersss();
    }
}



//核心: 匿名内部类是 子类对象
class outer222{

    public void method(){
        new Object(){
            public void show(){

            }
        }; // 编译通过

//        Object obj = new Object(){
//            public void show();
//        };
//        obj.show(); // 编译失败,因为匿名内部类是子类对象, 当object obj 指向时, 就被提升obj 而obj类中没有定义show方法;
    }
}

