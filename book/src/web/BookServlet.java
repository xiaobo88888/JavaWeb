package web;

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    /**
     * 用来做分页的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：pageNo, pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService的page()方法，返回一个Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        
        //设置后台的url
        page.setUrl("manager/bookServlet?action=page");
        
        //3.将Page对象保存到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
    
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;//这里始终加一页，因为如果超过总页码，则会跳到总页码，如果没超过，则跳到最后一页（因为再次添加，总页码可能会变）
        
        req.setCharacterEncoding("UTF-8");
        //1.获取请求的参数，封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.addBook()方法保存图书
        bookService.addBook(book);
        //3.调到图书列表页面 /manager/bookServlet?action=list
        //不推荐使用请求转发
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        //这里应该使用重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }
    
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.获取请求的参数，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService的deteletBookById()，删除图书
        bookService.deleteBookById(id);
        //3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    
    
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.获取请求的参数，封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.updateBook(Book)方法，修改图书
        bookService.updateBook(book);
        //3.重定向回图书列表管理页面 
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到request域中
        req.setAttribute("books", books);
        //3.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 获取要修改的图书信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.queryBookById()方法查询图书
        Book book = bookService.queryBookById(id);
        //3.保存图书到request域中
        req.setAttribute("book", book);
        //4.请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    
}
