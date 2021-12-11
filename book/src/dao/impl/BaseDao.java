package dao.impl;

import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();


    /**
     * update() 方法用来执行 insert/update/delete语句
     * @param sql
     * @param args
     * @return 如果返回-1，则说明执行失败，其他则说明执行成功
     */
    public int update(String sql, Object... args){
        System.out.println("BaseDao在[" + Thread.currentThread().getName() + "现称中]");
        
        Connection connection = JdbcUtils.getConnection();
        try {
            //正常情况下返回影响的行数
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            
            //dao的操作一定要往外抛，因为得在回滚事务之前捕获异常，如果在这里就捕获了，回滚事务之前就捕获不到了，就不会回滚事务
            throw new RuntimeException(throwables);
        }/*dao中关闭连接的操作都不能有了，因为是在提交或者回滚事务的时候才关闭连接，确保都是同一个连接
        finally {
            JdbcUtils.close(connection);
        }*/

        /*return -1;*/
    }


    /**
     * 查询返回一条JavaBean的sql语句
     * @param sql 执行的sql语句
     * @param type 返回的对象类型
     * @param args sql语句执行的参数值
     * @param <T> 返回类型的泛型
     * @return
     */
    public <T> T queryForOne(String sql, Class<T> type, Object ... args){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            //dao的操作一定要往外抛，因为得在回滚事务之前捕获异常，如果在这里就捕获了，回滚事务之前就捕获不到了，就不会回滚事务
            throw new RuntimeException(throwables);
        }/*dao中关闭连接的操作都不能有了，因为是在提交或者回滚事务的时候才关闭连接，确保都是同一个连接
        finally {
            JdbcUtils.close(connection);
        }*/

        /*return null;*/
    }

    /**
     * 返回多条JavaBean的数据
     * @param sql 执行的sql语句
     * @param type 返回的对象类型
     * @param args sql语句执行的参数值
     * @param <T> 返回类型的泛型
     * @return
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object ... args){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            //dao的操作一定要往外抛，因为得在回滚事务之前捕获异常，如果在这里就捕获了，回滚事务之前就捕获不到了，就不会回滚事务
            throw new RuntimeException(throwables);
        }/*dao中关闭连接的操作都不能有了，因为是在提交或者回滚事务的时候才关闭连接，确保都是同一个连接
        finally {
            JdbcUtils.close(connection);
        }*/

        /*return null;*/
    }

    /**
     * 查询返回特殊值
     * @param sql 执行的sql语句
     * @param args 执行sql语句需要的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            //dao的操作一定要往外抛，因为得在回滚事务之前捕获异常，如果在这里就捕获了，回滚事务之前就捕获不到了，就不会回滚事务
            throw new RuntimeException(throwables);
        }/*dao中关闭连接的操作都不能有了，因为是在提交或者回滚事务的时候才关闭连接，确保都是同一个连接
        finally {
            JdbcUtils.close(connection);
        }*/

       /*return null;*/
    }
}
