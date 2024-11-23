package jie.hfut.schedule.test;

import org.junit.Test;

/**
 * ClassName: TestBaseDao
 * Package: jie.hfut.schedule.test
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/23 23:04
 * @Version 1.0
 */
public class TestBaseDao {
    @Test
    public void testExecute(){
        // 测试非查询执行


    }



    @Test
    public void testExecuteQuery(){
        // 测试查询代码
        BaseDao baseDao = new BaseDao();
        // 查询表 sys_user 用户数量
        String sql = "select count(1) from sys_user";



    }
}
