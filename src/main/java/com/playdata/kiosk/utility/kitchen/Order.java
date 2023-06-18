package com.playdata.kiosk.utility.kitchen;

public class Order {

    //상품객체로 바꿀 예정
    private String product;
    //유저객체로 바꿀 예정
    private String user;
    private boolean isPrepared = false;

    public Order(String product, String user) {
        this.product = product;
        this.user = user;
    }

    public void bePrepared(){
        isPrepared = true;
    }
}
