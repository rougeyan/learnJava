package src.fanxing;

/**
 * 泛型接口,把泛型定义在接口上
 * list,Collection集合,都是接口,
 * 都带泛型
 */
public class fanxingJiekou {
    public static void main(String[] args) {
//        interimpl<String> inter= new interimpl<String>();
                new interimpl<String>().show("hehe");
    }
}
// 泛型接口;
// 由使用者来定义类型
interface Inter<T>{ // 形参
    void show(T t); // 实参数
}

//class interimpl implements Inter<String>{
//    public void show(String e){
//
//    }
//}

/**
 * 子类也不确定类型 子类继续加泛型,
 * 由创建对象的时候才明确类型;
 *
 * 如果没有泛型,怎么使用? <T> 没有 即使用Object;
 */
class interimpl<T> implements Inter<T>{
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
