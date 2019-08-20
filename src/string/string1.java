package src.string;

/**
 * String
 * 字符串是一个对象
 * 字符串一旦初始化就不可以被改变
 *
 *  String类
 *  1.字符串都是对象
 *  2. 一旦初始化 就不可以更改;
 *  3.字符串可以共享
 */
public class string1 {

    public static void main(String[] args) {
        String str = "abcd"; //这就是一个对象
        String s1 = "abcde";
        String s2 = "abcde";
        System.out.println(str);
        System.out.println(s1 == s2);

        String s3 = "abc";
        String s4 = new String("abc");
        System.out.println(s3 == s4); // false
        // String.equals 复写了方法;
        System.out.println(s3.equals(s4)); //true
        /**
         * s3 和s4 有什么区别
         * s3 创建 在内存中有一个对象
         * s4 创建 在内存中两个对象
         */
    }
}
