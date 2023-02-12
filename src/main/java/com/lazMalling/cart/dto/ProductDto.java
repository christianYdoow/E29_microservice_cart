package com.lazMalling.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private long userId;
}
