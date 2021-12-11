package dao;

import bean.Order;

public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);
}
