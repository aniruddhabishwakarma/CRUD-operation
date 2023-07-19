package com.example.first.myFirstRESTApi.exception;

import lombok.Data;

@Data
public class VotersServiceCustomException extends RuntimeException {
    private String errorCode;

    public VotersServiceCustomException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
