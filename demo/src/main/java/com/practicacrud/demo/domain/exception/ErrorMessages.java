package com.practicacrud.demo.domain.exception;

public enum ErrorMessages {

    // USER
    NAME_INVALID("El nombre no puede estar vacío."),
    LASTNAME_INVALID("El apellido no puede estar vacío."),
    USER_NOT_FOUND("No hemos encontrado el usuario que nos indicaste."),
    AGE_INVALID("La edad no es válida.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
