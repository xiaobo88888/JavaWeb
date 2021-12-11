package dao.impl;

import bean.Order;
import dao.OrderDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        System.out.println("OrderDaoImpl在[" + Thread.currentThread().getName() + "现称中]");


        String sql = "insert into t_order (order_id, create_time, price, status, user_id) values(?, ?, ?, ?, ?)";
        
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
