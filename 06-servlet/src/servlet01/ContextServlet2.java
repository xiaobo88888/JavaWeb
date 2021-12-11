package servlet01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //4.可以像Map一样存储数据
        //可以直接通过getServletContext()方法获取ServletContext对象
        ServletContext context = getServletContext();

        System.out.println("保存之前的ContextServlet2中域数据key1的值" + context.getAttribute("key1"));
        System.out.println(context);
        context.setAttribute("key1", "value1");

        System.out.println("ContextServlet2中域数据key1的值" + context.getAttribute("key1"));
        System.out.println("ContextServlet2中域数据key1的值" + context.getAttribute("key1"));
        System.out.println("ContextServlet2中域数据key1的值" + context.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
