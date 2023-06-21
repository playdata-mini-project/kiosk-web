package com.playdata.kiosk.dto;

public class ProductDto {
    private  int id;
    private String name;
    private int categoryId;
    private int quantity;
    private int price;
    private int makeTime;
    private int addQuantity;

    public ProductDto(int id, String name, int categoryId, int quantity, int price, int makeTime) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
        this.makeTime = makeTime;

    }

    public ProductDto(String name, int categoryId, int quantity, int price , int makeTime) {
        this.name = name;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
        this.makeTime = makeTime;
    }

    public ProductDto(int id, int quantity, int addQuantity) {
        this.id = id;
        this.quantity = quantity;
        this.addQuantity = addQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAddQuantity() {
        return addQuantity;
    }

    public void setAddQuantity(int addQuantity) {
        this.addQuantity = addQuantity;
    }
}