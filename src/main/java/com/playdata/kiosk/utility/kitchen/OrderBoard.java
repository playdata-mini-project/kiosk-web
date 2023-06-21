package com.playdata.kiosk.utility.kitchen;

import java.util.LinkedList;
import java.util.Queue;

public class OrderBoard {

    private static int todayOrderNumber = 0;
    private static final Queue<OrderList> orders= new LinkedList<>();

    public static void addOrder(String product){
        orders.add(null);
    }


}
