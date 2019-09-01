package src.learnjdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * JDBC 简易工具类
 * JDBC 操作数据库的步骤
 * 1. 注册数据库驱动
 * 2. 建立数据库连接
 * 3. 创建一个Statement
 * 4. 执行SQL语句
 * 5. 处理结果集
 * 6. 关闭数据库连接(必须,每次都要关闭)
 */

public class UtilsDemo {


    /*
     * 连接数据库的driver，url，username，password通过配置文件来配置，可以增加灵活性
     * 当我们需要切换数据库的时候，只需要在配置文件中改以上的信息即可
     *
     * */

    private static String  driver = null;
    private static String  url = null;
    private static String  username = null;
    private static String  password = null;

    static {
        try {
            //获取配置文件的读入流
            /**
             * 这里目录需要你注意的是;
             */
            InputStream inputStream = UtilsDemo.class.getClassLoader().getResourceAsStream("./src/db.properties");
            // 这里配置文件可以任意放的位置, 如果放在src里面就使用  .getResourceAsStream("../../../db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            //获取配置文件的信息
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            System.out.println(driver);


            //加载驱动类
            Class.forName(driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    // 建立数据库连接,
    public static Connection getConnection() throws SQLException {
        System.out.println("数据库连接成功");
        return DriverManager.getConnection(url,username,password);
    }
    // 关闭数据库连接
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 进阶改造
    // 增删改
    // 增删改 只有SQL语句和传入参数是不确定的,所以调用方来传入
    // 我们发现 增删改进入的参数是各种类型的,而且数目是不确定的,所以使用Object
    public static void update(String sql,Object[] obj){
        Connection connection = null;
        PreparedStatement pstm = null;
        try{
            connection = getConnection();
            pstm = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pstm.setObject(i+1,obj[i]);
            }
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // release();
        }
    }
    /**
     * 1.对应查询语句来说 不知道对集合结果做数目操作 =>常用的是吧数据封装成Bean对象,封装成List集合
     * 2.可以定义一个接口,让调用者把接口实现类传递进来
     * 3.这样接口调用的方法就是调用者传递进来实现类的方法 [策略模式]
     */
    public static Object query(String sql, Object[] obj, BeanHandler rsh){
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            preparedStatement =connection.prepareStatement(sql);
            // 根据传递进来的参数,设置SQL占位符的值;
            if(obj !=null){
                for (int i = 0; i < obj.length; i++) {
                    preparedStatement.setObject(i+1,obj[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return  rsh.handler(resultSet);
    }
}

