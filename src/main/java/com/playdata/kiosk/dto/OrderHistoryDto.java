package com.playdata.kiosk.dto;

import java.util.Date;

public class OrderHistoryDto {
    private String uname;
    private String cname;
    private String pname;
    private int amount;
    private int price;
    private Date orderedAt;

    public OrderHistoryDto(String uname, String cname, String pname, int amount, int price, Date orderedAt) {
        this.uname = uname;
        this.cname = cname;
        this.pname = pname;
        this.amount = amount;
        this.price = price;
        this.orderedAt = orderedAt;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }
}
