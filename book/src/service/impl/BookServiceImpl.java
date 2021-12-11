package service.impl;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        
        
        //设置每页显示的数量
        page.setPageSize(pageSize);
        
        //求得总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        
        //求得总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        /*数据边界的检查，如果小于第一页，则赋值为1，如果大于最大页数，则赋值为最大页数*/
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

        //求得当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        //求得当前页数据
        List<Book> items = bookDao.queryForItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();


        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求得总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求得总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        /*数据边界的检查，如果小于第一页，则赋值为1，如果大于最大页数，则赋值为最大页数*/
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

        //求得当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        //求得当前页数据
        List<Book> items = bookDao.queryForItemsByPrice(begin, pageSize, min, max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
