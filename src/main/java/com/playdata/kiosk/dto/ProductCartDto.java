package com.playdata.kiosk.dto;

import java.util.Objects;

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

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public ProductCartDto(Long id, String name, int quantity, int price, int priceTotal, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.priceTotal = priceTotal;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCartDto that = (ProductCartDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductCartDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", priceTotal=" + priceTotal +
                ", image='" + image + '\'' +
                '}';
    }
}
