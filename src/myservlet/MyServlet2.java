package src.myservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * httpServlet 去继承servlet 表面重写太多方法;
 *
 * 一般我们开发的时候，都是重写doGet()和doPost()方法的。
 */
public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        /**
         * 对开发而言,通常是get和post方法提交给服务器
         */
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        /**
         * 对开发而言,通常是get和post方法提交给服务器
         */
        resp.getWriter().write("come on baby");
        // 获取web.xml下的属性;
        ServletConfig sc = this.getServletConfig();
        String value = sc.getInitParameter("name");
        System.out.println(value);


        //ServletContext对象
        ServletContext servletContext = this.getServletContext();

        String v = "zhongfucheng";

        //MyName作为关键字，value作为值存进   域对象【类型于Map集合】
        servletContext.setAttribute("MyName", v);

        // HttpServletResponse 应用;
        // outputStream是输出二进制数据的
        ServletOutputStream sos = resp.getOutputStream();
        sos.print("aaaa"); // correct
        // sos.print("aaaa"); // error 错误 UTF-8 错误

        // 解决办法:
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.getOutputStream().write("你好啊我是中国".getBytes("UTF-8"));

    }
}
