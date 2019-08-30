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
}
