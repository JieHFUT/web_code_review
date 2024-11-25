package jie.hfut.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jie.hfut.schedule.common.Result;
import jie.hfut.schedule.common.ResultCodeEnum;
import jie.hfut.schedule.pojo.SysUser;
import jie.hfut.schedule.service.SysUserService;
import jie.hfut.schedule.service.impl.SysUserServiceImpl;
import jie.hfut.schedule.util.MD5Util;

import java.io.IOException;

/**
 * ClassName: SysUserController
 * Package: jie.hfut.schedule.controller
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/24 12:48
 * @Version 1.0
 */

@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();
    /**
     * 接收用户进行注册请求的业务逻辑处理方法（接口-前后端业务处理对接接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收客户端提交的参数（username userPwd）
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        // 2.调用服务层的方法，完成注册功能
            // 将参数放入一个 SysUser 对象中，在调用 regist 方法的时候传入
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);
        // 3.根据注册业务的返回结果（注册成功/注册失败），进行页面跳转
        if (rows > 0) {
            // 重定向到注册成功页面
            resp.sendRedirect("/registSuccess.html");
        } else {
            // 重定向到注册失败页面
            resp.sendRedirect("/registFail.html");
        }
    }


    /**
     * 接收用户登录请求时候，完成登录业务的方法（登录业务接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 2.调用 service 层方法查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        if (null == loginUser) {
            // 没有找到该用户名对应的用户信息
            resp.sendRedirect("/loginUsernameError.html");

        // 3.找到了对应的用户信息，判断用户密码是否正确
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())){
            // 用户密码错误
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            // 4.登录成功，跳转相关页面
            // 登陆成功之后，将登陆成功的用户信息放进 session 域
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", loginUser);
            resp.sendRedirect("/showSchedule.html");
        }
    }


    /**
     * 用于检查在注册时候，接收注册的用户名，校验用户名是否被占用的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名
        String username = req.getParameter("username");
        // 调用服务层的业务处理方法查询该用户名是否有对应的用户
        SysUser sysUser = userService.findByUsername(username);

        // 在这里响应一个成功的状态码：ok()方法中自己添加了一个 sucess 的枚举
        Result result = Result.ok(null);

        if (null != sysUser) {
            // 有该用户 => 响应已被占用
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        // 把 result 对象转换成为 JSON 串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        // 如果没有该用户 => 响应可用
        // 告诉客户端响应是一种 JSON 串
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
