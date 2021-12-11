package servlet01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        /*因为ServletContext对象是在web工程启动的时候创建的，再web停止时销毁，所以在ContextServlet2中创建了
        * ServletContext对象，所以在ContextServlet3中可以取出ServletContext的值*/
        System.out.println(context);
        System.out.println("ContextServlet3中域数据key1的值" + context.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
