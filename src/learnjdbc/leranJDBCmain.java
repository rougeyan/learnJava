package src.learnjdbc;

import java.sql.*;

/**
 * [封装JDBC通用工具类jdbc-utils](https://www.iteye.com/blog/cloudpure-2400097)
 * [JDBC 使用db.properties 获取数据库连接](https://www.cnblogs.com/ms-grf/p/7041666.html)
 * [Java中使用db.properties属性文件](https://blog.csdn.net/pan_junbiao/article/details/89404620)
 * [自定义的jdbc连接工具类JDBCUtils【java 工具类】](https://www.cnblogs.com/mujingyu/p/7878687.html)
 * [尚学堂037 - 董寒冰的文章 - 知乎](https://zhuanlan.zhihu.com/p/80026511)
 * [asdJDBCUtils工具类编写](https://blog.csdn.net/weixin_42691149/article/details/82086321)
 * [大学生刚学完 Java 如何学习 SpringMVC？](http://zhihu.com/question/327107482/answer/718731277)
 */

/**
 * executeQuery 查询用到 返回resultSet
 * executeUpdate 增删改 都用到 返回init
 */
public class leranJDBCmain {
    public static void main(String[] args) {
        leranJDBCmain st = new leranJDBCmain();
        // 查询
//        st.selectTest();
        // 增
        st.insertTest("yanzhihaoha",23);
        // 删除
        st.deleteTestByUserName("yanzhihaoha");
        // 改
        st.UpdateByUserName("yanzhihaoha");
    }
    // 测试查询
    public void selectTest(){
        Connection con =null;
        Statement  stm =null;    // Statement
        PreparedStatement pstm = null;  // PreparedStatement;
        ResultSet rs =null;
        try{
            // 建立连接
            con = UtilsDemo.getConnection();
            System.out.println(con);
            // 创建Statement
            stm = con.createStatement();
            // 处理结果集
            rs = stm.executeQuery("select * from user");
            while (rs.next()){
                System.out.println(rs.next());
                int uid = rs.getInt("id");
                System.out.println(uid);
//                String username = rs.getString("user_name");
//                System.out.println(username);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilsDemo.release(con,stm,rs);
        }
    }
    // 增加
    public void insertTest(String name,int age){
        Connection con =null;
        PreparedStatement pstm = null;  // PreparedStatement
        int rs;
        try{
            String sql = "insert into user(user_name,user_age) values(?,?)";
            con = UtilsDemo.getConnection();
            /**
             * 这里是使用preStatement;
             * 与Statement 不一样;
             */
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, age);
            rs = pstm.executeUpdate();
            System.out.println(rs);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilsDemo.release(con,pstm,null);
        }
    }

    // 删除
    public void deleteTestByUserName(String deleteuserName){
        Connection con =null;
        PreparedStatement pstm = null;  // PreparedStatement
        try{
            String sql = "delete from user where user_name =?";
            con = UtilsDemo.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1,deleteuserName);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilsDemo.release(con,pstm,null);
        }
    }

    // 查询
    public void UpdateByUserName(String updateName){
        Connection con =null;
        PreparedStatement pstm = null;  // PreparedStatement
        ResultSet rs = null;
        try{
            String sql = "SELECT * from user where user_name = ?";
            con = UtilsDemo.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1,updateName);
            rs = pstm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("user_name")+"----"+rs.getInt("user_age"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilsDemo.release(con,pstm,rs);
        }
    }
}
