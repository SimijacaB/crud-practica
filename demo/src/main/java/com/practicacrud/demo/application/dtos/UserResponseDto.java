package com.practicacrud.demo.application.dtos;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UserResponseDto {
    private String id;
    private String name;
    private String lastName;
    private Integer age;

}
