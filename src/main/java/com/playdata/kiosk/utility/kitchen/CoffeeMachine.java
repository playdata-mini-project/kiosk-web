package com.playdata.kiosk.utility.kitchen;

public class CoffeeMachine extends Thread{

    private final int SECOND = 1000;

    //커피를 뱉을 거임
    public void make(String product){
        OrderQueue.addOrder(product);
        try {
            Thread.sleep(SECOND); //product.getMakeTime(); 이랑 곱할거임
            //order.bePrepared();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
