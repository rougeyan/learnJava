package src.string;

public class string5builder {
    public static void main(String[] args) {
        /**
         * stirngBuilder 和stringbuffer 的区别:
         *  功能一样;
         *
         * stringbuilder 不保证同步, 线程安全;
         *
         * 多线程
         * append delete insert
         *
         * 单线程访问stringbuffer
         * 1.5jdk
         * 比buffer快;
         *
         * stirngBuilder: 非同步, 单线程访问效率高;
         * stirngBuffer:  同步,多线程访问安全;
         *
         */
    }
}
