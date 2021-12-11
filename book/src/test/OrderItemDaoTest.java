package test;


import bean.OrderItem;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;


public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        
        orderItemDao.saveOrderItem(new OrderItem(null, "java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaScript从入门到入土", 2, new BigDecimal(100), new BigDecimal(200), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaWeb从入门到入土", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));

    }
}