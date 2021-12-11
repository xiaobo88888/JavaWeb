package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter(){
        System.out.println("1.Filter的AdminFilter()构造器方法");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的init初始化方法");
        
        //1.获取Filter名称filter-name的内容
        System.out.println("filter-name的值是：" + filterConfig.getFilterName());
        //2.获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username的值是：" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + filterConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println("ServletContext对象：" + filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter过滤方法");
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        
        if(user == null){
            // 如果等于 null，说明还没有登录
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }else{
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的destroy()销毁方法");
    }
}
