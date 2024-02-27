package com.practicacrud.demo.infraestructure.input.rest;

import com.practicacrud.demo.application.dtos.UserRequestDto;
import com.practicacrud.demo.application.dtos.UserResponseDto;
import com.practicacrud.demo.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;
    @Operation(summary = "Add a new User ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User Already exists", content = @Content)
    })

    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDto userRequestDto) {
        userHandler.createUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class )))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserFromAppById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(userHandler.getUserById(id));
    }

    @Operation(summary = "Get users by name ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class )))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponseDto>> getUserFromAppByName(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(userHandler.getUserByName(name));
    }

    @Operation(summary = "Get users by last name ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<UserResponseDto>> getUserFromAppByLastName(@PathVariable(name = "lastName") String lastName){
        return ResponseEntity.ok(userHandler.getUsersByLastName(lastName));

    }

    @Operation(summary = "Get users by age ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })

    @GetMapping("/age/{age}")
    public ResponseEntity<List<UserResponseDto>> getUserFromAppByAge(@PathVariable(name = "age") Integer age){
        return ResponseEntity.ok(userHandler.getUsersByAge(age));

    }

    @Operation(summary = "Get all the users ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users returned", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class )))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity.ok(userHandler.getAllUsers());

    }

    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class )))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PutMapping("/")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDto userRequestDto){
        userHandler.updateUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class )))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId")  String userId){
        userHandler.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}
