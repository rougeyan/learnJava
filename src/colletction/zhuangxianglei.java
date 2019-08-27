package src.colletction;

/**
 * 基本数据类型封装成对象,提供更多的操作方法;
 * 基本数据类型包装类;
 * byte Byte
 * short Short
 * int Integer
 * long Long
 * float Float
 * double Double
 * boolean Boolean
 * char Character
 *
 * 学习Integer
 *
 * 特点:
 * 用于基本数据与字符串之间的转换;
 *
 * 解析: 必须会;
 *
 *
 */
public class zhuangxianglei {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(10)); // 10进制转2进制
        System.out.println(Integer.toHexString(10)); // 10=>16
        System.out.println(Integer.toOctalString(10)); // 10==>8
        /**
         * 字符串转换成数值;
         * int parseInt()
         *
         * byte
         */
        System.out.println(Integer.parseInt("1235")+3);
        System.out.println(Integer.parseInt("110",2)); // 指定进制
        System.out.println(Integer.parseInt("a1",16)); // 指定进制 16进制

        // 34+"" String.valueOf(34); Integer.toString(int)

        //基本数值 => 包装对象;

        Integer i = new Integer(4);
        Integer ii = new Integer("4");
        Integer iii = Integer.valueOf(4);

        //包装对象 => 基本数值
        int num = i.intValue();


        /**
         * 自动装箱拆箱
         */

        // int a = 4;
        // Integer a = new Integer(4);

        // JDK 1.5之后
        Integer aaa = 4; // 自动装箱  代码恒等于 Integer aaa = Integer.valueOf(4);
        aaa = aaa +5; // aaa = aaa.intValue() +5 加法运算后 再次装箱;


        /**
         * 细节
         */
        Integer ha = new Integer(3);
        Integer ba = new Integer(3);
        System.out.println(ha==ba); // false
        System.out.println(ha.equals(ba)); // true;


        Integer ca = 100;
        Integer da = 100;
        System.out.println(ca==da); // true
        System.out.println(ca.equals(da)); // true;

    }
}
