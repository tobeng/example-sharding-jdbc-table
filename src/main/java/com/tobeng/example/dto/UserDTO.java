package com.tobeng.example.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotNull(message = "id can't be empty!")
    private Long id;

    @NotBlank(message = "city can't be empty!")
    private String city;

    @NotBlank(message = "name can't be empty!")
    private String name;

}
