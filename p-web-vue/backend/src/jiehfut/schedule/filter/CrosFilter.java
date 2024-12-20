package jiehfut.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jiehfut.schedule.common.Result;
import jiehfut.schedule.util.WebUtil;

import java.io.IOException;

/**
 * ClassName: CrosFilter
 * Package: jiehfut.schedule.filter
 * Description:
 * 跨域问题的过滤器，过滤全部资源
 *    如果请求是 OPTIONS 请求,就是跨域请求，响应允许跨域的信息，请求到此为止
 *    如果请求不是 OPTIONS 请求，直接放行
 * @Author jieHFUT
 * @Create 2024/12/20 21:55
 * @Version 1.0
 */
@WebFilter("/*")
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getMethod());
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT,OPTIONS, DELETE, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");
        // 如果是跨域预检请求,则直接在此响应 200 业务码
        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            WebUtil.writeJson(response, Result.ok(null));
        }else{
            // 非预检请求,放行即可
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
