package com.practicacrud.demo.infraestructure.output.jpa.repository;

import com.practicacrud.demo.infraestructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IUserRepository extends JpaRepository<UserEntity, String> {

    Optional<List<UserEntity>> findByName(String name);

    Optional<List<UserEntity>> findByLastName(String lastName);

    Optional<List<UserEntity>> findByAge(Integer age);


}
