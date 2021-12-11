package service.impl;

import bean.*;
import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    
    @Override
    public String createOrder(Cart cart, Integer userId) {
        System.out.println("OrderServiceImpl在[" + Thread.currentThread().getName() + "现称中]");
        
        //订单号，要确保唯一性
        //通过时间戳和用户id来确保唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        
        //保存订单
        orderDao.saveOrder(order);
        
        
        //遍历购物车中的每一个商品项并转换成订单项
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            //获取购物车中的每一个商品项
            CartItem cartItem = entry.getValue();
            //将商品项转换成订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);
            
            
            //更新库存和销量
            
            //每保存一个订单项，就要修改一个Book，因为库存和销量都被修改了
            //先得到Book
            Book book = bookDao.queryBookById(cartItem.getId());
            //修改Book的销量
            //销量变为原来的销量加上这个商品的数量
            book.setSales(book.getSales() + cartItem.getCount());
            //修改Book的库存
            //库存变为原来的库存减去这个商品的数量
            book.setStock(book.getStock() - cartItem.getCount());
            //然后将Book的信息保存起来，就是更新Book信息
            bookDao.updateBook(book);
        }
        //结账后，将购物车中的商品清空
        cart.clear();
        
        return orderId;
    }
}
