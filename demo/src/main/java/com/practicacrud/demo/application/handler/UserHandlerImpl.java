package com.practicacrud.demo.application.handler;

import com.practicacrud.demo.application.dtos.UserRequestDto;
import com.practicacrud.demo.application.dtos.UserResponseDto;
import com.practicacrud.demo.application.mapper.IUserRequestMapper;
import com.practicacrud.demo.application.mapper.IUserResponseMapper;
import com.practicacrud.demo.domain.api.IUserServicePort;
import com.practicacrud.demo.domain.exception.ErrorMessages;
import com.practicacrud.demo.domain.exception.UserValidationException;
import com.practicacrud.demo.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;



    @Override
    public void createUser(UserRequestDto userRequestDto) {

        User user = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(user);

    }

    @Override
    public void updateUser(UserRequestDto userRequestDto) {

        User user = userRequestMapper.toUser(userRequestDto);
        userServicePort.updateUser(user);

    }

    @Override
    public void deleteUser(String userId) {

        userServicePort.deleteUser(userId);

    }

    @Override
    public UserResponseDto getUserById(String userId) {

        return userResponseMapper.toUserResponse(userServicePort.getUserById(userId));

    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        return userResponseMapper.toUserResponseList(userServicePort.getAllUsers());
    }

    @Override
    public List<UserResponseDto> getUserByName(String name) {
        return userResponseMapper.toUserResponseList(userServicePort.getUsersByName(name));
    }

    @Override
    public List<UserResponseDto> getUsersByLastName(String lastName) {
        return userResponseMapper.toUserResponseList(userServicePort.getUsersByLastName(lastName));
    }

    @Override
    public List<UserResponseDto> getUsersByAge(Integer age) {
        return userResponseMapper.toUserResponseList(userServicePort.getUsersByAge(age));
    }
}
