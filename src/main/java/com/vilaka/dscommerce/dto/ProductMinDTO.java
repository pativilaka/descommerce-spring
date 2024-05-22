package com.vilaka.dscommerce.dto;

import com.vilaka.dscommerce.entities.Product;
import lombok.Getter;

@Getter
public class ProductMinDTO {

    private Long id;
    private String name;
    private Double price;
    private String imgURL;

    public ProductMinDTO(Long id, String name,  Double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
    }

    public ProductMinDTO(Product entity){
        id = entity.getId();;
        name = entity.getName();
        price = entity.getPrice();
        imgURL = entity.getImgUrl();
    }
}
