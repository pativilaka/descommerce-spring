package com.vilaka.dscommerce.dto;

import lombok.Getter;

@Getter
public class FieldMessage {
    private String fieldname;
    private String message;

    public FieldMessage(String fieldname, String message) {
        this.fieldname = fieldname;
        this.message = message;
    }
}
