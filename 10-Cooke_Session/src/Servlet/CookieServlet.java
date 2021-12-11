package Servlet;

import Utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        
        cookie.setPath(req.getContextPath() + "/abc");
        
        resp.addCookie(cookie);
        
        resp.getWriter().write("创建一个了带有Path路径的Cookie");
    
    }
    
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        
        cookie.setMaxAge(60 * 60);//浏览器上的时期用的是格林时间
        
        resp.addCookie(cookie);
        
        resp.getWriter().write("已经创建了一个存活一小时的Cookie");
    
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先找到你要删除的Cookie
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        //2.然后通过setMaxAge(0)设置立即删除
        if(cookie != null){
            cookie.setMaxAge(0);
            //3.调用response.addCookie()
            resp.addCookie(cookie);
            
            
            resp.getWriter().write("key1的Cookie已经被删除了");
        }
        
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        
        cookie.setMaxAge(-1);//设置存活时间
        
        resp.addCookie(cookie);
    
    
    }
        protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//方案一： 
        //1.先创建一个同名的Cookie对象
        //2.在构造器同时赋予新的Cookie值
        Cookie cookie = new Cookie("key1", "newValue1");
        //3.调用response.addCookie( Cookie )  通知客户端保存修改
        resp.addCookie(cookie);
        
        resp.getWriter().write("key1的Cookies已经被修改好了");*/
        
        
        //方案二：
        //1.先查到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        //这里要判断一下，因为有可能查不到这个Cookie
        if(cookie != null){
            //2.调用setValue()方法赋予新的Cookie值
            cookie.setValue("newValue2");
            //3.调用response.addCookie()方法保存修改
            resp.addCookie(cookie);
        }
        
        
    }

        protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getName()方法返回Cookie的key (名)
            //getValue()方法返回Cookie的value(值)
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        Cookie iwantCookie = CookieUtils.findCookie("key1", cookies);
        
        //如果不是null，那么说明iwantCookie以被赋值，也就是找到了
        if(iwantCookie != null){
            resp.getWriter().write("想要的Cookie找到了！");
        }
    }
    
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key2", "value2");
        //通知客户端保存Cookie
        resp.addCookie(cookie);
    
        //可以一次性创建多个Cookie
        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("key3", "value3");
        //通知客户端保存Cookie
        resp.addCookie(cookie1);
        
        resp.getWriter().write("Cookie对象创建成功");
    }
}
