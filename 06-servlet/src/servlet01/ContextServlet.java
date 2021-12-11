package servlet01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();

        System.out.println("context-param参数username的值是" + context.getInitParameter("username"));
        System.out.println("context-param参数password的值是" + context.getInitParameter("password"));

        //2.获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径" + context.getContextPath());
        //3.获取工程部署后在服务器硬盘上的绝对路径

        /**
         *  / 斜杠被服务器解析为： http://ip:port/工程名/        映射到IDEA代码的web目录
         */
        System.out.println("工程部署在服务器硬盘上的绝对路径为：" + context.getRealPath("/"));

        System.out.println("工程下css目录的绝对路径是：" + context.getRealPath("/css"));
        System.out.println("工程下img目录的绝对路径是：" + context.getRealPath("/img"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
