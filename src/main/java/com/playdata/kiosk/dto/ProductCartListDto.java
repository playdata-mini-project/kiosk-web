package com.playdata.kiosk.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductCartListDto {
    private List<ProductCartDto> productCartList;

    public List<ProductCartDto> getProductCartList() {
        return productCartList;
    }

    public ProductCartListDto() {
        this.productCartList = new ArrayList<>();
    }
    public void addCartList(ProductCartDto cart) {
        boolean isDuplicate = false;
        for(ProductCartDto productCartDto : productCartList) {
            // 중복일경우 수량추가후 isDuplicate 값 true 설정
            if(productCartDto.equals(cart)) {
                productCartDto.increaseQuantity(cart.getQuantity());
                System.out.println("Adding cart: " + cart.getName());
                isDuplicate = true;
                break;
            }
        }
        // 중복이 아닐경우 카트 리스트에 추가한다.
        if(!isDuplicate){
            System.out.println("Adding cart: " + cart.getName());
            productCartList.add(cart);
        }
    }
}
