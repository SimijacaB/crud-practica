package com.practicacrud.demo.infraestructure.exceptionHandler;

/*
Se le muestra a mensajes al usuario si tengo una excepcion, este será enviado
como tipo Json clave: valor
 */
public enum ExceptionResponse {

    USER_NOT_FOUND("No User was found with that id"),
    USER_ALREADY_EXISTS("There is already a user with that id"),
    NO_DATA_FOUND("No data found for request petition");

    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }





}
