package src.learnjdbc;

import java.sql.*;

public class learnjdbc {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/sqltest?useSSL=false&serverTimezone=GMT";
    //用户名
    private static final String USER_NAME = "root";//数据库账号
    //密码
    private static final String PASSWORD = "bigben978";//数据库密码

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName(DRIVER_NAME);

            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //定义sql语句 ?表示占位符
            String sql1 = "select * from user where user_name =?";
            String sql2 = "Update users Set user_age='13' where user_name=yan";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql1);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
             preparedStatement.setString(1, "yan");
            //向数据库发出sql执行查询，查询出结果集
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("user_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 释放资源

            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
