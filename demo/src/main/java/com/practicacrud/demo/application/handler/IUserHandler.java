package com.practicacrud.demo.application.handler;

import com.practicacrud.demo.application.dtos.UserRequestDto;
import com.practicacrud.demo.application.dtos.UserResponseDto;
import com.practicacrud.demo.domain.model.User;

import java.util.List;

public interface IUserHandler {

    void createUser(UserRequestDto userRequestDto);

    void updateUser(UserRequestDto userRequestDto);

    void deleteUser(String userId);

    UserResponseDto getUserById(String userId);

    List<UserResponseDto> getAllUsers();

    List<UserResponseDto> getUserByName(String name);

    public List<UserResponseDto> getUsersByLastName(String lastName);

    public List<UserResponseDto> getUsersByAge(Integer age);

}
