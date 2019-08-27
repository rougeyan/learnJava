package src.colletction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class collection2 {
    public static void main(String[] args) {
        Collection cec = new ArrayList();
        pesommm s1 = new pesommm("张三",13);
        pesommm s2 = new pesommm("李四",14);
        pesommm s3 = new pesommm("王五",15);
        pesommm s4 = new pesommm("王五",15);
        cec.add(s1);
        cec.add(s2);
        cec.add(s3);
        cec.add(s4);

        // 判断重复:
        // 已经都是通过方法来完成
        // 快捷键 itco
        for (Iterator iterator = cec.iterator(); iterator.hasNext(); ) {
            pesommm next = (pesommm) iterator.next();
            System.out.println(next.getName());

        }

        // 插入元素 collection 不具备插入功能


    }
}

