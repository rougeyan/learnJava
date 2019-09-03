package src.myservlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * [Servlet第一篇【介绍Servlet、HTTP协议、WEB目录结构、编写入门Servlet程序、Servlet生命周期】](https://segmentfault.com/a/1190000013124026)
 */

public class MyServlet1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init() was finished");
    }

    // 获取配置
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("hello world");
        System.out.println("service again");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory() was finished");

    }
}

