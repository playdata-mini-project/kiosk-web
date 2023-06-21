package com.playdata.kiosk.utility.kitchen;

import com.playdata.kiosk.dto.ProductDetailDto;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeMachine extends Thread{

    private static final int SECOND = 1000;
    private static Queue<Orders> queue = new LinkedList<>();

    private static Long todayOrderNumber = 0L;
    private String productName;
    private int makeTime;
    private int amount;
    private String userName;

    public CoffeeMachine(String productName, int makeTime, int amount, String userName) {
        this.productName = productName;
        this.makeTime = makeTime;
        this.amount = amount;
        this.userName = userName;
    }

    public void make() {
        Orders orders = new Orders(productName, makeTime, amount, userName);

        OrderBoardService.todayOrder.put(++todayOrderNumber, orders);

        try {
            queue.offer(orders);
            Thread.sleep(makeTime * amount * SECOND);
            orders.bePrepared();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        make();
    }
}
