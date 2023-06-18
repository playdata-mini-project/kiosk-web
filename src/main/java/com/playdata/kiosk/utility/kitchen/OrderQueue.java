package com.playdata.kiosk.utility.kitchen;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {

    private static int todayOrderNumber = 0;
    private static final Queue<Order> orders= new LinkedList<>();

    public static void addOrder(String product){
        orders.add(null);
    }


}
