package com.jiehfut.headline.service;

import com.jiehfut.headline.pojo.NewsUser;

/**
 * ClassName: NewsUserService
 * Package: com.jiehfut.headline.service
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/22 20:16
 * @Version 1.0
 */
public interface NewsUserService {
    /**
     * 根据用户登录的账号密码，查询用户对象，如果找到，返回密文 token
     * @param username
     * @return 返回密文 token
     */
    NewsUser findByUsername(String username);

    /**
     * 用户登录后，请求头中携带 token 信息，响应用户 uid && 用户名
     * @param uid
     * @return
     */
    NewsUser findByUid(Integer uid);
}
