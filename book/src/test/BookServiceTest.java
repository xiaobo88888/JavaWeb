package test;

import bean.Book;
import bean.Page;
import org.junit.Test;
import service.BookService;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "EDG牛逼", "EDG", new BigDecimal(9999.99), new Integer(99999), new Integer(99), null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "EDG就是牛逼", "EDG", new BigDecimal(9999.99), new Integer(99999), new Integer(0), null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for( Book book : bookService.queryBooks()){
            System.out.println(book);
        }
    }
    
    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE, 5, 20));
    }
}