package web;

import bean.Cart;
import bean.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        
        //再获取用户id
        User loginUser = (User) req.getSession().getAttribute("user");
        //这里要判断loginUser是否有值，因为用户可能没有登录
        if(loginUser == null){
            //跳转到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;//之后的代码都不执行，所以加个return
        }
        Integer userId = loginUser.getId();

        System.out.println("OrderServlet在[" + Thread.currentThread().getName() + "现称中]");
        
        //调用OrderService的createOrder(cart, userId)方法生成订单
        String orderId = orderService.createOrder(cart, userId);
        
        /*//将订单编号设置到Request域中
        req.setAttribute("orderId", orderId);
        
        //请求转发到/pages/cart/checkout.jsp页面
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);*/
        
        //为了防止表单重复提交，这里采用重定向的方式，并把订单号保存到Session中
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
        
    }
}
