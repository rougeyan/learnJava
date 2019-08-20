package src.string;

/**
 * stringbuffer
 *
 * 字符串缓冲区 支持可变的字符串;
 */
public class string4buffer {
    public static void main(String[] args) {
        // stringbuffer
        // 1. 是一个字符串缓冲区;
        // 2. 长度是可变,任意类型都可以; 注意: 是将任意数据都转成字符串进行存储;
        // 3. 容器对象提供很多对容器中数据操作的功能 添加,删除 查找 修改;增删改查
        // 4. 必须所有的的数据变成一个字符串;

        // 和数组最大的不同的
        // 数组存储完可以单独操作每一个人元素 每个一个元素是独立的;
        // 字符串缓冲区: 所有存储的元素都被转成字符串,最后拼接成打的字符串;

        // 创建缓冲区;
        StringBuffer sb = new StringBuffer();
        // 1. 添加数据
        // 链式调用;
        String str = sb.append(true).append("hehe").toString();
        System.out.println(str);
        // sb.insert(2,"it"); // 插入 //顺势删除
        System.out.println(sb);
        // sb.delete(1,4);
        System.out.println(sb);

        sb.replace(1,4,"cast");

//        sb.setLength(2);
        System.out.println(sb);
        // 字符串缓冲区具体逻辑
        // s = new StringBuffer().append('a').append(5).append('haha');
        // 翻转
        sb.reverse();
    }
}
