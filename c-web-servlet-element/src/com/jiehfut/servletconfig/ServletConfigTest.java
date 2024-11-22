package com.jiehfut.servletconfig;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigTest extends HttpServlet {


    /*<servlet>
        <servlet-name>servletConfigTest</servlet-name>
        <servlet-class>com.jiehfut.servletconfig.ServletConfigTest</servlet-class>

        <!--配置 servlet 的初始参数-->
        <init-param>
            <param-name>key</param-name>
            <param-value>value</param-value>
        </init-param>
        <init-param>
            <param-name>key1</param-name>
            <param-value>value1</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>servletConfigTest</servlet-name>
        <url-pattern>servletConfigTest</url-pattern>
    </servlet-mapping>*/

    /**
     * Tomcat 在读取到上面这些信息后就会对 servlet 进行构造
     * 在构造的时候，Tomcat 将配置中的初始参数放进 ServletConfig 对象
     * Tomcat 在调用 servletConfigTest，在进行 init() 的时候，会将这个对象传入，存在父类 GenericServlet 的 config 属性中
     * 我们就可以读到初始化的配置信息：getServletConfig()
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        // 根据参数名获取初始配置信息
        String key = servletConfig.getInitParameter("key");
        System.out.println("key = " + key);

        // 获取所有的初始参数的名字，返回的是早期的 Iterator
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        // hasMoreElements 判断有没有下一个参数，如果有就返回 true，没有就返回 false
        while (initParameterNames.hasMoreElements()) {
            // 取出下一个元素，并且向下移动游标
            String initParameterName = initParameterNames.nextElement();
            System.out.println("initParameterName = " + initParameterName);
        }


    }


}
