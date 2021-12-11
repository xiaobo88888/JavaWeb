package dao.impl;

import bean.Book;
import dao.BookDao;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book (name, price, author, sales, stock, img_path) values (?, ?, ?, ?, ?, ?)";
        
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath()); 
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        System.out.println("BookDaoImpl[" + Thread.currentThread().getName() + "现称中]");


        String sql = "update t_book set name = ?, price = ?, author = ?, sales = ?, stock = ?, img_path = ? where id = ?";
        
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id, name, author, price, sales, stock, img_path from t_book where id = ?";
        return queryForOne(sql, Book.class, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id, name, author, price, sales, stock, img_path from t_book";
        return queryForList(sql, Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        
        Number count = (Number) queryForSingleValue(sql);
        
        return count.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        String sql = "select id, name, author, price, sales, stock, img_path from t_book limit ?, ?";
        return queryForList(sql, Book.class, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";

        Number count = (Number) queryForSingleValue(sql, min, max);

        return count.intValue();
    }

    @Override
    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id, name, author, price, sales, stock, img_path " +
                "from t_book where price between ? and ? order by price limit ?, ?";
        return queryForList(sql, Book.class, min, max, begin, pageSize);
    }
}
