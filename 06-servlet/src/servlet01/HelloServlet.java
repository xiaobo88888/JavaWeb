package servlet01;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1. 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. init 方法");

        //1.可以获取Servlet程序的别名Servlet-name的值
        System.out.println("HelloServlet程序的别名是" + servletConfig.getServletName());
        //2.获取初始化参数 init-param
        System.out.println("初始化参数username的值是" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是" + servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println("ServletContext对象是" + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. service 方法 == HelloServlet 被访问了");
        //类型转换，因为ServletRequest的子接口HttpServletRequest才有getMethod方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //得到请求的方式
        String method = httpServletRequest.getMethod();

        //因为实际操作中，get和post请求要做的操作很多，所以可以通过方法调用来完成
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }

    /**
     * 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
     * 做post请求的操作
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. destroy 销毁方法");
    }
}
