package com.playdata.kiosk.utility.kitchen;

import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.ProductDetailDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBoardService {
    public static final Map<Long, Orders> todayOrder = new HashMap<>();
    private final ProductDao productDao = new ProductDao();

    public void 알바야커피만들어라(Long productId, int amount, String userName){
        ProductDetailDto productDetailDto = productDao.productDetail(productId);

        CoffeeMachine coffeeMachine = new CoffeeMachine(
                productDetailDto.getName(),
                productDetailDto.getMakeTime(),
                amount,
                userName);

        coffeeMachine.start();
    }
    public List<Orders>[] 알바야주문번호확인해라(){
        List<Orders> completes = new ArrayList<>();
        List<Orders> incompletes = new ArrayList<>();

        List<Orders>[] lists = new List[2];
        lists[0] = completes;
        lists[1] = incompletes;

        for (Long todayOrderNumber : todayOrder.keySet()) {
            Orders order = todayOrder.get(todayOrderNumber);

            if(order.getCompletion() == Completion.COMPLETE){
                completes.add(order);
            } else {
                incompletes.add(order);
            }
        }
        //0 완성... 1 미완성...
        return lists;
    }
}
