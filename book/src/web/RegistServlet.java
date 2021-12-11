package web;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检验验证码是否正确————先写死为abcde
        if("abcde".equalsIgnoreCase(code)){
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
