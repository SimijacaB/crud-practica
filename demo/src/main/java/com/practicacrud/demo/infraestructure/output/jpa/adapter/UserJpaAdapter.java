package com.practicacrud.demo.infraestructure.output.jpa.adapter;

import com.practicacrud.demo.domain.model.User;
import com.practicacrud.demo.domain.spi.IUserPersistencePort;
import com.practicacrud.demo.infraestructure.exception.NoDataFoundException;
import com.practicacrud.demo.infraestructure.exception.UserAlreadyExistException;
import com.practicacrud.demo.infraestructure.exception.UserNotFoundException;
import com.practicacrud.demo.infraestructure.output.jpa.entity.UserEntity;
import com.practicacrud.demo.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.practicacrud.demo.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        if ( userRepository.findById(user.getId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUserById(String userId) {
        return userEntityMapper.toUser(userRepository.findById(userId).orElseThrow(UserNotFoundException::new));

    }

    @Override
    public List<User> getAllUsers() {

        List<UserEntity> userEntityList = userRepository.findAll();
        if (userEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public List<User> getUsersByName(String name) {

        if(userRepository.findByName(name).isEmpty()){
                throw new NoDataFoundException();
        }

        List<UserEntity> userEntityList = userRepository.findByName(name).get();
        return userEntityMapper.toUserList(userEntityList);

    }

    @Override
    public List<User> getUsersByLastName(String lastName) {

        if(userRepository.findByLastName(lastName).isEmpty()){
            throw new NoDataFoundException();
        }

        List<UserEntity> userEntityList = userRepository.findByLastName(lastName).get();
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public List<User> getUsersByAge(Integer age) {
        if(userRepository.findByAge(age).isEmpty()){
            throw new NoDataFoundException();
        }

        List<UserEntity> userEntityList = userRepository.findByAge(age).get();
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public void updateUser(User user) {

        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void deleteUser(String id) {

        userRepository.deleteById(id);

    }

}

