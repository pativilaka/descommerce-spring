package com.vilaka.dscommerce.dto;

import com.vilaka.dscommerce.entities.Product;
import lombok.Getter;

@Getter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgURL;

    public ProductDTO(Long id, String name, String description, Double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }

    public ProductDTO(Product entity){
        id = entity.getId();;
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgURL = entity.getImgUrl();
    }
}
