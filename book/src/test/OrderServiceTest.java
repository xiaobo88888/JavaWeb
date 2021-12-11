package test;

import bean.Cart;
import bean.CartItem;
import org.junit.Test;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "aaaa", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "aaaa", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "bbbb", 2, new BigDecimal(100), new BigDecimal(200)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }
}