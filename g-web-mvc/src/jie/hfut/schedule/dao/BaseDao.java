package jie.hfut.schedule.dao;

import jie.hfut.schedule.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: BaseDao
 * Package: jie.hfut.schedule.dao
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/23 23:24
 * @Version 1.0
 */
public class BaseDao {

    /**
     * 公共的查询方法，返回的是单个的对象
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     */
    public <T> T baseQueryObject(Class<T> clazz, String sql, Object... args) {
        T t = null;
        // 获取连接池中的一个连接
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0;
        try {
            // 准备语句对象
            preparedStatement = connection.prepareStatement(sql);
            // 设置语句中的参数
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            // 执行查询
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // next 指针向下移动一次为 true，说明查询到了数据
                t = (T) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            JdbcUtil.releaseConnection();
        }
        return t;
    }


    /**
     * 公共的查询方法，返回的是单个的集合
     * @param clazz
     * @param sql
     * @param args
     * @return
     * @param <T>
     */
    public <T> List<T> baseQueryList(Class<T> clazz, String sql, Object... args) {

    }











}
