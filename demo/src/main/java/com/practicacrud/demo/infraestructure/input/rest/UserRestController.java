package com.practicacrud.demo.infraestructure.input.rest;

import com.practicacrud.demo.application.dtos.UserRequestDto;
import com.practicacrud.demo.application.dtos.UserResponseDto;
import com.practicacrud.demo.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;


    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDto userRequestDto) {
        userHandler.createUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserFromAppById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(userHandler.getUserById(id));
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<UserResponseDto>> getUserFromAppByName(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(userHandler.getUserByName(name));
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<List<UserResponseDto>> getUserFromAppByLastName(@PathVariable(name = "lastName") String lastName){
        return ResponseEntity.ok(userHandler.getUsersByLastName(lastName));

    }
    @GetMapping("/{age}")
    public ResponseEntity<List<UserResponseDto>> getUserFromAppByAge(@PathVariable(name = "age") Integer age){
        return ResponseEntity.ok(userHandler.getUsersByAge(age));

    }
    @PutMapping("/")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDto userRequestDto){
        userHandler.updateUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId")  String userId){
        userHandler.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}
