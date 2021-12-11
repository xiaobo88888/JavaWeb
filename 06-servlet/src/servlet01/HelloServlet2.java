package servlet01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //假如要重写init方法，一定要记住这个super.init(config)不能丢失
        super.init(config);

        System.out.println("重写了init方法，做了一些工作");
    }

    /**
     * doGet() 在get请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloServlet2 get请求被调用");


        // 不能在自己的Servlet的程序中得到别人的Servlet程序信息
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        //所以这里是不会输出值的，都为null
        //要想得到信息，就得自己去web.xml里面自己配置信息
        System.out.println("初始化参数username的值是" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是" + servletConfig.getInitParameter("url"));
    }

    /**
     * doPost() 在post请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloServlet2 post请求被调用");
    }
}
