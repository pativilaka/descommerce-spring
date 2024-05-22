package com.vilaka.dscommerce.dto;

import com.vilaka.dscommerce.entities.Category;
import com.vilaka.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido!")
    private String name;
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank
    private String description;
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgURL;

    @NotEmpty(message = "Deve ter ao menos 01 categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

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
        for (Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }
}
