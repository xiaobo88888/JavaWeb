package web;

import bean.Book;
import bean.Cart;
import bean.CartItem;
import com.google.gson.Gson;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("商品编号:" + req.getParameter("id"));
        
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService的queryBookById(id):book得到图书的信息
        Book book = bookService.queryBookById(id);
        //把图书的信息转成CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
//        Cart cart = new Cart();
        //这里不能每次都new一个购物车。这样就不能累计添加商品了
        
        //先从Session中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //然后判断是否为空，为空就新建一个，不为空就直接添加
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        
        //重定向回商品列表
        //这里就不单单只是跳转到首页了
//        resp.sendRedirect(req.getContextPath());
        //而是跳转到原来商品的地址
        resp.sendRedirect(req.getHeader("Referer"));
        
        /*每次添加都将书名添加到Session域中，这样每次调用都会修改lastName的值，
        最后一次调用后，lastName就会保存最后一次保存的信息了，也就是最后一个添加的书名
        这样就可以起到最后一次添加图书的信息的功能了*/
        req.getSession().setAttribute("lastName", cartItem.getName());
    }

    /**
     * 通过ajax添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("商品编号:" + req.getParameter("id"));

        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService的queryBookById(id):book得到图书的信息
        Book book = bookService.queryBookById(id);
        //把图书的信息转成CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
//        Cart cart = new Cart();
        //这里不能每次都new一个购物车。这样就不能累计添加商品了

        //先从Session中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //然后判断是否为空，为空就新建一个，不为空就直接添加
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        
        
        /*每次添加都将书名添加到Session域中，这样每次调用都会修改lastName的值，
        最后一次调用后，lastName就会保存最后一次保存的信息了，也就是最后一个添加的书名
        这样就可以起到最后一次添加图书的信息的功能了*/
        req.getSession().setAttribute("lastName", cartItem.getName());
        
        //通过json返回购物车中的总商品数量和最后一个商品名称
        Map<String, Object> resultMap = new HashMap<>();
        
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());
        
        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        
        resp.getWriter().write(resultMapJsonString);
    }

    /**
     * 删除购物车中的商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //从Session中获取Cart对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        
        if(cart != null){
            //如果不为空，则调用Cart对象的deleteItem方法删除商品项
            cart.deleteItem(id);
            //然后重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //如果不为空，则调用Cart的clear方法清空购物车
            cart.clear();
            //然后重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号和商品数量
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        
        //获取购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        
        if(cart != null){
            //调用Cart对象的updateCount方法修改商品数量
            cart.updateCount(id, count);
            //然后重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
