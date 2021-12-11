package test;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "刘博好帅", "刘博", new BigDecimal(99999), new Integer(9999), new Integer(9999), null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "刘博还是这么帅", "刘博", new BigDecimal(99999), new Integer(9999), new Integer(0), null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book book : books){
            System.out.println(book);
        }
    }
    
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForItems() {
        for (Book book : bookDao.queryForItems(0, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(5, 20));
    }

    @Test
    public void queryForItemsByPrice() {
        for (Book book : bookDao.queryForItemsByPrice(0, Page.PAGE_SIZE, 5, 20)) {
            System.out.println(book);
        }
    }
}