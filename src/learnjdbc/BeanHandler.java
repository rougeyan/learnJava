package src.learnjdbc;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.lang.*;

interface ResultSetHandler{
    Object handler(ResultSet resultSet);
}
// 接口实现类, 对结果结封装成一个Bean对象
public class BeanHandler implements ResultSetHandler{
    // 要封装成一个Bean对象, 首先要知道Bean是什么,也就是调用者传递进来的;
    private Class clazz;

    public BeanHandler(Class clazz){
        this.clazz = clazz;
    }
    @Override
    public Object handler(ResultSet resultSet) {
        try{
            Object bean = clazz.newInstance();
            if (resultSet.next()){
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    // 获取每列的列名
                    String columnName = rsmd.getColumnName(i+1);
                    // 获取每列的数据
                    String columnData = resultSet.getString(i+i);
                    // 设置Bean属性
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);;
                    field.set(bean,columnData);
                }
            }
            return bean;
        }catch (SQLException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
