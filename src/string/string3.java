package src.string;

/**
 * comparable
 */
// mac 快捷键 common +n 构造器
public class string3 implements Comparable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 构造器
    public string3() {
        super();
    }
    // 构造器
    public string3(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    // 覆盖toString表现形式
    @Override
    public String toString() {
        return "string3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // 函数复写
    @Override
    public int compareTo(Object o) {
        // 向下转型 传进来的是object;
        // 我需要的是 子类特有内容
        // 因此需要向下转型;
        // 同时进行判定 o与string3 是否所属于;
        if (!(o instanceof string3)){
            throw new ClassCastException("类型错误");

        }
        string3 p = (string3)o;

//        if(this.age >p.age)
//            return 1;
//        if(this.age<p.age){
//            return -1;
//        }
        return this.age - p.age;
    }

    // 判定对象是否相等

    /**
     *  建立person对象 判断是否相同的依据;
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (!(obj instanceof string3)){
            throw new ClassCastException("类型错误");
        }
        string3 p = (string3)obj;

        return this.name.equals(p.name) && this.age ==p.age;
    }
}

