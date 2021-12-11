package dao;

import bean.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);
    
    int deleteBookById(Integer id);
    
    int updateBook(Book book);
    
    Book queryBookById(Integer id);
    
    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max);
}
