package com.practicacrud.demo.domain.usecase;


import com.practicacrud.demo.domain.api.IUserServicePort;
import com.practicacrud.demo.domain.exception.ErrorMessages;
import com.practicacrud.demo.domain.exception.UserValidationException;
import com.practicacrud.demo.domain.model.User;
import com.practicacrud.demo.domain.spi.IUserPersistencePort;
import java.util.List;

public class UserUseCase implements IUserServicePort {


    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        // VALIDACIONES
        if(!isValidId(user.getId())){
            throw new UserValidationException(ErrorMessages.ID_INVALID.getMessage());
        }

        if (!isValidName(user.getName())){
            throw new UserValidationException(ErrorMessages.NAME_INVALID.getMessage());
        }
        if (!isValidLastName(user.getLastName())){
            throw new UserValidationException(ErrorMessages.LASTNAME_INVALID.getMessage());
        }
        if (!isValidAge(user.getAge())){
            throw new UserValidationException(ErrorMessages.AGE_INVALID.getMessage());
        }
        userPersistencePort.saveUser(user);
    }

    @Override
    public User getUserById(String userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userPersistencePort.getUsersByName(name);
    }

    @Override
    public List<User> getUsersByLastName(String lastName) {
        return userPersistencePort.getUsersByLastName(lastName);
    }

    @Override
    public List<User> getUsersByAge(Integer age) {
        return userPersistencePort.getUsersByAge(age);
    }

    @Override
    public void updateUser(User user) {

        if (!isValidName(user.getName())){
            throw new UserValidationException(ErrorMessages.NAME_INVALID.getMessage());
        }
        if (!isValidLastName(user.getLastName())){
            throw new UserValidationException(ErrorMessages.LASTNAME_INVALID.getMessage());
        }
        if (!isValidAge(user.getAge())){
            throw new UserValidationException(ErrorMessages.AGE_INVALID.getMessage());
        }
        User updatedUser = new User(user.getId(), user.getName(), user.getLastName(), user.getAge());
        userPersistencePort.updateUser(updatedUser);
    }

    @Override
    public void deleteUser(String id) {
        userPersistencePort.deleteUser(id);
    }



    // VALIDACIONES CORRESPONDIENTES A LA CAPA DEL DOMINIO
    // En esta capa se hacen las validaciones para que el usuario digite un nombre válido (solo letras y números) y que no este vacío

    public boolean isValidId(String id){
        if (id == null || id.isEmpty()){
            return false;
        }
        String regex = "^[0-9]+$";
        return id.matches(regex);
    }
    public boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        // Usamos una expresión regular para verificar que el nombre contenga solo letras
        String regex = "^[A-Za-z]+$";
        return name.matches(regex);
    }

    public boolean isValidLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            return false;
        }
        // Usamos una expresión regular para verificar que el nombre contenga solo letras
        String regex = "^[A-Za-z]+$";
        return lastName.matches(regex);
    }

    public boolean isValidAge(Integer age){
        return age >= 0 && age <= 100;
    }


}
