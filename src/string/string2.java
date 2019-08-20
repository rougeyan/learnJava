package src.string;

public class string2 {
    public static void main(String[] args) {
        /**
         *  "abcde"
         *  1. 字符串是一个对象, 它的方法必然围绕这个对象的数据而定义的
         *  2. 拥有的功能
         *   2.1 有多少个字符  length()
         *      返回类型 int()
         *   2.2 字符的位置
         *      int indexof(ch,formIndex)
         *   2.3 获取指定位置上的字符
         *      char charAt(int)
         *   2.4 获取部分字符串
         *      String (int start, int end)
         */
        String str = "abacdefadsfasdfsa12351aa";
        int len = str.length();
        System.out.println(len);

        //
        int index = str.indexOf('a');
        System.out.println(index);

        // 函数重载 都是indexof的方法;
        // 找第二个a
        int index2a = str.indexOf('a',index+1);
        System.out.println(index2a);
        // 从最后开始
        int indexlasta =str.lastIndexOf('a');
        System.out.println(indexlasta);


        // 2.3
        str = "itcast";
        char ch = str.charAt(3);
        System.out.println(ch);

        // 2.4
        String s = str.substring(2,4); //ca 需要2-4;
        // 0 - lenth;
        System.out.println(s);
        // 包含头 不包含尾;






    }
}
