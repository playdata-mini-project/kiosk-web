package com.playdata.kiosk.dto;

public class ProductDetailDto {
    private Long id;
    private String name;
    private int price;
    private String image;
    private int quantity;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductDetailDto() {
    }

    public ProductDetailDto(Long id, String name, int price, String image, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }
}
