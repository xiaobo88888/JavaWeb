package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游，Response1");

       /* //设置响应状态码
        resp.setStatus(302);
        //设置响应头，告诉新的地址信息
        resp.setHeader("Location", "http://localhost:8080/07_Servlet/response2");*/

        //更加简便的方法设置请求重定向
        resp.sendRedirect("http://localhost:8080/07_Servlet/response2");
    }
}
