package com.jiehfut.headline.dao;

import com.jiehfut.headline.pojo.NewsUser;

/**
 * ClassName: NewsUserDao
 * Package: com.jiehfut.headline.dao
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/22 20:12
 * @Version 1.0
 */
public interface NewsUserDao {

    /**
     * 根据用户登录的账号密码，查询用户对象，如果找到，返回密文 token
     * @param username
     * @return 返回密文 token
     */
    NewsUser findByUsername(String username);
}
