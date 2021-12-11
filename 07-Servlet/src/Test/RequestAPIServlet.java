package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//记住这里要导jar包并设置给这个模块
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getRequestURI()      获取请求的资源路径
        System.out.println("uri:" + req.getRequestURI());
        // getRequestURL()      获取请求的统一资源定位符
        System.out.println("url:" + req.getRequestURL());
        // getRemoteHost()      获取客户端的ip地址
        /**
         * 在IDEA中，使用 localhost 访问时，得到的客户端ip地址是 ===>>> 120.0.0.1
         * 在IDEA中，使用 120.0.0.1 访问时，得到的客户端ip地址是 ===>>> 120.0.0.1
         * 在IDEA中，使用 真实ip 访问时，得到的客户端ip地址是 ===>>> 真实的客户端ip地址
         */
        System.out.println("客户端ip地址：" + req.getRemoteHost());
        // getHeader()          获取请求头
        System.out.println("请求头User-Agent：" + req.getHeader("User-Agent"));
        // getMethod()          获取请求的方式 GET或POST
        System.out.println("获取请求的方式：" + req.getMethod());
    }
}
