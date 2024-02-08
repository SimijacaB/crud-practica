package com.practicacrud.demo.domain.api;

import com.practicacrud.demo.domain.model.User;

import java.util.List;

public interface IUserServicePort {

    public void saveUser(User user);

    public User getUserById(String userId);

    public List<User> getAllUsers();

    public List<User> getUsersByName(String name);

    public List<User> getUsersByLastName(String lastName);

    public List<User> getUsersByAge(Integer age);
    //UPDATE
    public void updateUser(User user);

    //DELETE
    public void deleteUser(String id);


}
