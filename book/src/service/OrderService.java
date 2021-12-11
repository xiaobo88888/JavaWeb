package service;

import bean.Cart;

public interface OrderService {
    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return 订单号
     */
    String createOrder(Cart cart,Integer userId);
}
