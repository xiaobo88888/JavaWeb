package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 服务器默认字符集是ISO-8859-1
//        System.out.println(resp.getCharacterEncoding());

       /* //设置服务器的字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器的字符集为UTF-8
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");*/

        //它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        //但此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8");


        //这两个方法只能使用一个
//        resp.getWriter();
//        resp.getOutputStream();

        //往客户端回传字符串
        PrintWriter writer = resp.getWriter();
        writer.write("response Content!");
        //如果在未设置字符集的情况下，中文是乱码的
        //即使只在服务器设置字符集为UTF-8也会乱码的，因为这是要展示到浏览器上，所以浏览器上的字符集也要设置为UTF-8
        writer.write("刘博很帅");
    }
}
