package jie.hfut.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName: SysScheduleController
 * Package: jie.hfut.schedule.controller
 * Description:
 * 增加日程的请求: /schedule/add
 * 查询日程的请求: /schedule/find
 * 修改日程的请求: /schedule/update
 * 删除日程的请求: /schedule/remove
 * ...
 * @Author jieHFUT
 * @Create 2024/11/24 12:50
 * @Version 1.0
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 需要判断此次的请求是哪一种行为（增、删、改、查）
        String URI = req.getRequestURI(); // 拿到的 URI 就是形如：/schedule/add
        // 通过判断最后的 /** 获得具体行为
        String[] split = URI.split("/");
        String method = split[split.length - 1];

        // 通过反射技术，通过方法名来获取下面的方法
        Class aClass = this.getClass();
        // 获取方法
        try {
            // 获取方法
            Method declaredMethod = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            // 设置暴力破解方法的访问修饰符
            declaredMethod.setAccessible(true);
            // 执行方法
            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 没有实现该方法：" + method);
        }


        /*if (method.equals("add")) {
            // 做增加处理
            add(req, resp);
        } else if (method.equals("find")) {
            // 做查询处理
            find(req, resp);
        } else if (method.equals("update")) {
            // 做修改处理
            update(req, resp);
        } else if (method.equals("remove")) {
            // 做删除处理
            remove(req, resp);
        }*/
    }


    // 对上面的方法进行封装
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
    }
    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
    }








}
