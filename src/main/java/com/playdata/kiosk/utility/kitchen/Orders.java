package com.playdata.kiosk.utility.kitchen;

import com.playdata.kiosk.dto.ProductDetailDto;

public class Orders {
    private String productName;
    private int makeTime;
    private int amount;
    private String userName;
    private Completion completion = Completion.INCOMPLETE;

    public Orders(String productName, int makeTime, int amount, String userName) {
        this.productName = productName;
        this.makeTime = makeTime;
        this.amount = amount;
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public int getMakeTime() {
        return makeTime;
    }

    public int getAmount() {
        return amount;
    }

    public String getUserName() {
        return userName;
    }

    public Completion getCompletion() {
        return completion;
    }

    public void bePrepared(){
        completion = Completion.COMPLETE;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "productName='" + productName + '\'' +
                ", makeTime=" + makeTime +
                ", amount=" + amount +
                ", userName='" + userName + '\'' +
                ", completion=" + completion +
                '}';
    }
}
