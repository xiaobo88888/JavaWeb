package Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1(柜台1)中查看参数(材料):" + username);

        //给材料加盖一个章，并传递到Servlet2(柜台2)中
        req.setAttribute("key", "柜台1的章");

        //问路，Servlet2(柜台2)怎么走
        /**
         * 请求转发必须要以斜杠打头，    / 斜杠表示地址为：http://ip:port/工程名    映射到IDEA代码的web目录
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //因为请求转发可以转发到WEB-INF目录下，所以可以通过请求转发来访问浏览器访问不到的WEB-INF目录里的内容
        //这里假设a.html文件在WEB-INF目录下a
//        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("/WEB-INF/a.html");

        //走到Servlet2(柜台2
        //这里的参数是方法接收的参数
        requestDispatcher.forward(req, resp);

    }
}
