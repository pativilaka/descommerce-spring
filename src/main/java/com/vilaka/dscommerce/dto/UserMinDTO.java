package com.vilaka.dscommerce.dto;

import com.vilaka.dscommerce.entities.User;
import lombok.Getter;

@Getter
public class UserMinDTO {
    private Long id;
    private String name;

    public UserMinDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserMinDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }


}
