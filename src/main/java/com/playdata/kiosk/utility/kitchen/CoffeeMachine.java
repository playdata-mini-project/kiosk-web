package com.playdata.kiosk.utility.kitchen;

import com.playdata.kiosk.dto.ProductDetailDto;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeMachine extends Thread{

    private static final int SECOND = 1000;
    private static Queue<Orders> queue = new LinkedList<>();

    public Orders make(String productName, int makeTime, int amount, String userName){

        Orders orders = new Orders(productName, makeTime, amount, userName);

        try {
            queue.offer(orders);
            Thread.sleep(makeTime * amount * SECOND);
            orders.bePrepared();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
