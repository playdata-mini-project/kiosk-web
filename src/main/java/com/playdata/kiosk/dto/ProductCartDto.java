package com.playdata.kiosk.dto;

public class ProductCartDto {
    private Long id;
    private String name;
    private int quantity;
    private int price;
    private int priceTotal;

    private String image;

    public String getImage() {
        return image;
    }

    public int getPriceTotal() {
        return priceTotal;
    }
    public int getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCartDto(Long id, String name, int quantity, int price, int priceTotal, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.priceTotal = priceTotal;
        this.image = image;
    }
}
