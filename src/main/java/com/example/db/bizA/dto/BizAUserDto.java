package com.example.db.bizA.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BizAUserDto {

    @NotNull(message = "this field should be not null.")
    private Long id;
    private String name;

}
