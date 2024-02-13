package com.practicacrud.demo.infraestructure.output.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @Id
    private String id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;



}
