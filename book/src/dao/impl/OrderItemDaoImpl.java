package dao.impl;

import bean.OrderItem;
import dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl[" + Thread.currentThread().getName() + "现称中]");

        String sql = "insert into t_order_item(name, count, price, total_price, order_id) values (?, ?, ?, ?, ?)";
        
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
