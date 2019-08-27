package src.colletction;

// 常用的子接口 list set map

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;

/**
 * Collection
 *
 * list 有序 带索引,通过索引可以精确操作机会中的元素, 元素是可以重复的
 *      Lis提供增删改查操作
 *      增: add();
 *      删: remove()
 *      改: set()
 *      查: get
 *
 *      ArrayList: 数组结构,长度可变,不同步的;(常用的都是不同步的
 *      查询速度快,增加较慢
 *
 *      Vector: Vector是同步的, 效率低 被ArrayList替代;
 *
 *      LinkedList(不同步): 链接列表;
 *      链表结构,增删速度快;持有是地址 不是角标;
 *      查询速度慢;
 *          可用于实现堆栈,队列,双端队列;
 *          堆栈 先进后出;  First in Last Out; FILO   手枪弹夹,先进后出;
 *          队列: 先进先出; First in First Out; FIFO; 排队,先买票先里离开
 *
 *      我的下一个元素是确定的,持有下一个元素的引用
 * set 无序 不包含重复元素的集合; 不满足e1.equals(e2) 最多包含一个null
 *      不保证顺序;
 * 方法和collection一致
 *
 * set集合取出元素的方法只有一种:迭代器 Iterator;
 *  HashSet: 哈希表结构,不同步,保证元素唯一性的方式依赖于hasCode(),equals()方法;
 *      查询速度快;
 *  TreeSet: 可以对set集合中的元素进行排序;
 *      使用的是二叉树结构;如果保证唯一性?
 *      通过comparable 接口来实现排序比较,
 *      优势: 存完的数据具备树的功能;
 *      排序动作是自动的;
 *
 *      元素的排序动作有多重
 *      1. 元素自身具备自然排序,通过实现接口: 改写compareTo方法来实现
 *      如果元素自身不具备自然排序(如对象) 或者具备的自然排序不符合自身要求, 使用第二种方法;
 *      2. 比较器: 其实在创建TreeSet 的集合的时候,可以定义排序的方法;
 *      在构造函数中指定具体的比较方式;
 *      需要定义一个类实现接口,重写compare方法
 *      Comparator implements Comparator()
 *      TreeSet a = new TreeSet( new Comparator())
 *
 *      细节:方法都是抽象
 *      class CompartorByName extends Object implements Comparator{}
 *      默认继承了Object 因此不用重写写equals方法
 *
 *      比较器使用场景:
 *
 *      往集合中存储对象的时候,通常该对象都需要复写hasCode equals
 *      同时实现Comparable()接口,建立对象的自然排序,通常还有一个方法复写即 toString();
 *
 *  LinkedHashSet
 *   HashSet的子类 有序()
 *
 *
 *   集合对象小技巧:
 *   集合分体系: List Set
 *   List: 子类List 结尾,通常都是非同步,
 *      ArrayList: arr 数组 查询速度快
 *      LinkedList: linked 链表 增删速度快
 *   Set: 子类set
 *      HashSet 哈希表 查询速度更快, 元素唯一, 无序 通过hashCode equals方法判定唯一性;
 *      TreeSet 二叉树 可以排序 排序通过实现接口comparable- compareTo 以及Comparator-compare方法;
 *
 * map
 *
 * list 接口的特有方法, 全是围绕索引来定义;
 * list 中获取元素的方式
 *  1. 迭代 Iterator
 *  2. 遍历 get(索引)方法
 *  list 接口对元素 CRUD增删改查动作的
 */

public class collection3List {
    public static void main(String[] args) {
        List ls = new ArrayList();
        // 1. 使用list解决, 插入元素的问题, add是追加
        ls.add(new pesommm("张3",13));
        ls.add(new pesommm("张3",13));
        ls.add(new pesommm("张3",13));
        ls.add(new pesommm("张3",13));
        ls.add(new pesommm("李4",14));
        ls.add(new pesommm("王5",15));

        // 2. 插入元素
        ls.add(1,new pesommm("何6",18));

        // 4. 删除元素
        // ls.remove(4); //error 角标越界;

        // 5. 修改元素
        ls.set(1,new pesommm("何6666",18));

        Object obj = ls.get(1);
        System.out.println(obj);
        for (int i = 0; i < ls.size(); i++) {
            System.out.println("get("+i+")"+ls.get(i));

        }

        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            pesommm next = (pesommm) iterator.next();
            System.out.println(next);
        }
    }
}


class CompartorByName implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        pesommm s1 = (pesommm)o1;
        pesommm s2 = (pesommm)o2;
        int temp  = s1.getName().compareTo(s2.getName());
        return temp ==0?s1.getAge() - s2.getAge():temp;
    }
}
