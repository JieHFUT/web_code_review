package com.jiehfut.headline.controller;

/**
 * ClassName: PortalController
 * Package: com.jiehfut.headline.controller
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/22 20:21
 * @Version 1.0
 */

import com.jiehfut.headline.common.Result;
import com.jiehfut.headline.common.ResultCodeEnum;
import com.jiehfut.headline.pojo.NewsType;
import com.jiehfut.headline.pojo.NewsUser;
import com.jiehfut.headline.service.NewsTypeService;
import com.jiehfut.headline.service.NewsUserService;
import com.jiehfut.headline.service.impl.NewsTypeServiceImpl;
import com.jiehfut.headline.service.impl.NewsUserServiceImpl;
import com.jiehfut.headline.util.JwtHelper;
import com.jiehfut.headline.util.MD5Util;
import com.jiehfut.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户控制器
 * 那些不需要登录，不需要做增删改的门户页面的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController {

    private NewsTypeService newsTypeService = new NewsTypeServiceImpl();
    private NewsUserService newsUserService = new NewsUserServiceImpl();

    /**
     * 查询所有的新闻类型的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有的新闻类型，装入 Result 对象响应给前端
        List<NewsType> newsTypeList = newsTypeService.findAll();
        WebUtil.writeJson(resp, Result.ok(newsTypeList));
    }


    /**
     * 处理登录表单提交的业务接口的实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名和密码 JSON 串
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);
        // 调用服务层方法查找用户信息
        NewsUser loginUser = newsUserService.findByUsername(paramUser.getUsername());
        Result result = null;
        if (loginUser != null) {
            // 验证密码
            boolean isPasswordRight = MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd());
            if (isPasswordRight) {
                // 密码正确响应 token
                Integer uid = loginUser.getUid();
                String token = JwtHelper.createToken(uid.longValue());
                Map data = new HashMap();
                data.put("token", token);
                result = Result.ok(data);
            } else {
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            // 数据库里没有该用户信息
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        WebUtil.writeJson(resp, result);
    }
}
