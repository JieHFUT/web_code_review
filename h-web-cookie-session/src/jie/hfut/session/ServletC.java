package jie.hfut.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: ServletC
 * Package: jie.hfut.session
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/24 17:16
 * @Version 1.0
 */

@WebServlet("/servlstc")
public class ServletC extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的 username 参数

        // 获得 session 对象


    }
}
