package com.playdata.kiosk.utility.kitchen;

import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.ProductDetailDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBoardService {

    private static Long todayOrderNumber = 0L;
    private static final Map<Long, Orders> todayOrder = new HashMap<>();
    private final CoffeeMachine coffeeMachine = new CoffeeMachine();
    private final ProductDao productDao = new ProductDao();

    public void 알바야커피만들어라(Long productId, int amount, String userName){
        ProductDetailDto productDetailDto = productDao.productDetail(productId);

        Orders orders = makeCoffee(
                productDetailDto.getName(),
                productDetailDto.getQuantity(),
                amount,
                userName);

        todayOrder.put(++todayOrderNumber, orders);
    }
    public List[] 알바야주문번호확인해라(){
        List<Orders> completes = new ArrayList<>();
        List<Orders> incompletes = new ArrayList<>();

        for (Long todayOrderNumber : todayOrder.keySet()) {
            Orders order = todayOrder.get(todayOrderNumber);

            if(order.getCompletion() == Completion.COMPLETE){
                completes.add(order);
            } else {
                incompletes.add(order);
            }
        }
        //0 완성... 1 미완성...
        return new List[]{completes, incompletes};
    }
    private Orders makeCoffee(String productName, int makeTime, int amount, String userName){

        Orders orders = coffeeMachine.make(
                productName,
                makeTime,
                amount,
                userName);
        return orders;
    }
}
