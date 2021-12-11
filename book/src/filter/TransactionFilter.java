package filter;

import utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            
            //提交事务
            JdbcUtils.commitAndClose();
        }catch (Exception e){
            //回滚事务
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            
            //把异常继续抛给Tomcat服务器馆里展示友好界面，Tomcat服务器通过错误标签捕获了错误
            throw new RuntimeException(e);
        }
        
        
    }

    @Override
    public void destroy() {

    }
}
