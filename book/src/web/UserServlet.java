package web;

import bean.User;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import test.UserServletTest;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 验证用户名是否可用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExitsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数username
        String username = req.getParameter("username");
        
        //调用Service.exitsUsername方法
        boolean exitsUsername = userService.exitsUsername(username);
        
        //把返回的结果封装成Map对象
        Map<String, Object> map = new HashMap<>();
        
        map.put("exitsUsername", exitsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        
        //响应json数据
        resp.getWriter().write(json);
    }

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用userService.login登录处理业务
        User user = userService.login(new User(username, password, null));

        //如果user等于null，说明登录失败
        if(user == null){
            //将错误信息，和回显的表单项信息保存到request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);


            //失败，跳回登录页面
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            //保存用户登录的信息到Session域中
            req.getSession().setAttribute("user", user);
            //成功，则跳到成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.销毁Session中用户的登录信息（或者销毁Session)
        req.getSession().invalidate();
        //2.重定向的首页（或者登录页面）
        resp.sendRedirect(req.getContextPath());
    }
    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码，因为谷歌的jar包中生成验证码的时候也把验证码保存到Session域中了
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //然后立刻将验证码删除
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        
        
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        
        
        //2.检验验证码是否正确吗，验证码不写死
        if(token != null && token.equalsIgnoreCase(code)){
            //正确
            //3.检查用户名是否可用
            if(userService.exitsUsername(username)){
                //用户名已存在，不可用
                System.out.println("用户名" + username + "已存在");

                //将错误信息和回显的数据存放到request域中
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


                //跳回到注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                //用户名不存在，可用
                //调用service保存到数据库
                userService.registUser(new User(username, password, email));
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }else{
            //将错误信息和回显的数据存放到request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            //不正确
            //跳回注册页面
            System.out.println("验证码" + code + "不正确");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
    
    
}
