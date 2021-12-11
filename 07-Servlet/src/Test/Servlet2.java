package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1(柜台2)中查看参数(材料):" + username);

        //查看柜台1是否有章
        Object key = req.getAttribute("key");
        System.out.println("柜台1是否有章：" + key);

        //处理自己的业务
        System.out.println("Servlet2 处理自己的业务");


    }
}
