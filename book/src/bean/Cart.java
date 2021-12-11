package bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     * key是商品编号
     * value是商品信息，也就是商品项
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //先查看购物车中是否已经含有本商品，如果没有就加入购物车集合中，如果有就商品数量累加，总金额更新
        CartItem item = items.get(cartItem.getId());
        
        if(item == null){
            //如果没有添加过，则加入购物车中
            items.put(cartItem.getId(), cartItem);
        }else{
            //如果添加过，则商品数量累加，总金额更新
            item.setCount(item.getCount() + 1); //商品数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));  //总金额更新
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空商品
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count){
        //先查看是否由此商品，如果有，则更改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);   //更改商品数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));  //更新总金额
        }
    }
    
    public Integer getTotalCount() {
        Integer totalCount = 0;
        
        for(Map.Entry<Integer, CartItem>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        
        return totalCount;
    }

    //因为购物车总商品数量是根据商品项的数量累加求得的，所以不因存在直接赋值的方法

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Map.Entry<Integer, CartItem>entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }

    //因为购物车总商品总金额是根据商品项的金额累加求得的，所以不因存在直接赋值的方法

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
