package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);

            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，则表示获取连接失败
     */
    public static Connection getConnection(){
        Connection conn = conns.get();
        
        //如果是第一次连接
        if(conn == null){
            try {
                //那么就先从连接池中获取
                conn = dataSource.getConnection();
                
                //然后将连接保存到ThreadLocal中，供后面的jdbc操作使用
                conns.set(conn);
                
                //关闭自动提交，设置手动管理事务
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        
        return conn;
        /*Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;*/
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        //先从ThreadLocal中获取连接
        Connection conn = conns.get();
        
        //如果不等于null，说明之前使用过连接，操作过数据库
        if(conn != null){
            try {
                //提交事务
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    //关闭连接，释放资源
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        
        //最后一定要执行remove()移除操作，否则就会出错，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }

    /**
     * 回滚事务，并关闭连接
     */
    public static void rollbackAndClose(){
        //先从ThreadLocal中获取连接
        Connection conn = conns.get();

        //如果不等于null，说明之前使用过连接，操作过数据库
        if(conn != null){
            try {
                //回滚事务
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    //关闭连接，释放资源
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        //最后一定要执行remove()移除操作，否则就会出错，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }
    /**
     * 关闭连接，放回数据库连接池
     * @param connection
     *//*
    public static void close(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }*/
}
