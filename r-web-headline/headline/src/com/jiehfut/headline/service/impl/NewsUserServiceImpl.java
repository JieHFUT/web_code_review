package com.jiehfut.headline.service.impl;

import com.jiehfut.headline.dao.NewsUserDao;
import com.jiehfut.headline.dao.impl.NewsUserDaoImpl;
import com.jiehfut.headline.pojo.NewsUser;
import com.jiehfut.headline.service.NewsUserService;

/**
 * ClassName: NewsUserServiceImpl
 * Package: com.jiehfut.headline.service.impl
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/22 20:17
 * @Version 1.0
 */
public class NewsUserServiceImpl implements NewsUserService {

    private NewsUserDao newsUserDao = new NewsUserDaoImpl();

    @Override
    public NewsUser findByUsername(String username) {
        return newsUserDao.findByUsername(username);
    }
}
