package src.fanxing;

/**
 * 泛型的实际应用;
 */
public class fanxing3 {
    public static void main(String[] args) {
        // 最开始的转型类;
//        Alltooooo t = new Alltooooo();
//        t.setObj(5); 
//        String s = (String)t.getObj();// 省去了强转麻烦
//        System.out.println(s);

//        添加泛型后:
//        Altool<String> tt = new Altool();
//        tt.setObject("haha");
//        String ss = tt.getObject(); // 不再向下转型;
//        System.out.println(ss);


//      使用泛型类, 可以接入任何类型的
//      同时取元素的时候也不再确认是什么类型
        Altool<Integer> t3 = new Altool();
        t3.setObject(3);
        Integer s3 = t3.getObject();
        System.out.println(s3);
    }
}

// 这个类只能操作string
class Tool{
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
// 这个类只能操作Integer
class Tool2{
    private Integer inte;

    public Integer getInte() {
        return inte;
    }

    public void setInte(Integer inte) {
        this.inte = inte;
    }
}

class Alltooooo{
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
/**
 * 定义工具类型,
 * 对工具对象进行操作, 设置和获取,
 * 可以对任意对象进行操作,
 * 对共性Object 操作;
 *
 * 定义object可以,因为提升为了Object
 * 想要使用特有内容时,需要向下转型;
 * 容易引发ClassCastException
 *
 * jdk1.5以后 引入泛型 修改了;
 *
 * 在不确定对象类型的时候,定义成参数,由改类的调用者来传递类型
 * 将泛型定义在类上;
 */


// 泛型类
class Altool<Q>{
     private Q Object;

    public Q getObject() {
        return Object;
    }

    public void setObject(Q object) {
        Object = object;
    }
}
