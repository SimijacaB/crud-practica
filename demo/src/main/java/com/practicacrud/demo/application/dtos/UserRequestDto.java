package com.practicacrud.demo.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Id field must not be empty")
    private String id;

    @NotBlank(message = "Name field must not be empty")
    private String name;

    @NotBlank(message = "Last name field must not be empty")
    private String lastName;

    @PositiveOrZero(message = "Age must be positive")
    private Integer age;

}


