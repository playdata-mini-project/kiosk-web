package com.playdata.kiosk.dto;

public class ProductDto {
    private  int Id;
    private String Name;
    private int categoryId;
    private int quantity;
    private int price;
    private int makeTime;

    public ProductDto(int id, String name, int categoryId, int quantity, int price, int makeTime) {
        Id = id;
        Name = name;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
        this.makeTime = makeTime;

    }

    public ProductDto(String name, int categoryId, int quantity, int price , int makeTime) {
        Name = name;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
        this.makeTime = makeTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(int makeTime) {
        this.makeTime = makeTime;
    }
}