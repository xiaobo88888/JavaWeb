package dao;

import bean.OrderItem;

public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);
}
