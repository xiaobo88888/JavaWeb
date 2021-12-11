package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        
        resp.getWriter().write("Session的默认超时时长是：" + maxInactiveInterval + "秒 <br/>");

    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        //让Session会话马上超时
        session.invalidate();
        
        resp.getWriter().write("Session已经被设置为超时");
    }


    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Session对象
        HttpSession session = req.getSession();
        //然后设置当前Session3秒后销毁
        session.setMaxInactiveInterval(3);
        
        resp.getWriter().write("当前Session已经被设置为3秒后销毁");
    }

    /**
     * 往Session中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
    
        resp.getWriter().write("已经往Session中保存了数据");
    }

    /**
     * 获取Session中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        
        resp.getWriter().write("从Session域中获取的数据是" + attribute);

    }

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        
        //判断当前Session对象是否是新创建出来的
        boolean isNew = session.isNew();
        
        //获取Session会话的唯一标识id
        String id = session.getId();
        
        resp.getWriter().write("得到的Session，它的id是:" + id + "<br/>");
        resp.getWriter().write("这个Session是否是新创建的:" + isNew + "<br/>");

    }
}
