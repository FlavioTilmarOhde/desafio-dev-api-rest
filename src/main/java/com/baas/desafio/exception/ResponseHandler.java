package com.baas.desafio.exception;

public class ResponseHandler {

    private String type;
    private String message;

    public ResponseHandler(String type, String message) {
        this.setType(type);
        this.setMessage(message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
