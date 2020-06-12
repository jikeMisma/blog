package com.mzc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mazhicheng
 * @date 2020/5/1 - 12:31
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassNotFoundException extends RuntimeException {

    public ClassNotFoundException(){

    }
    public ClassNotFoundException(String message){
        super(message);
    }
    public ClassNotFoundException(String message, Throwable cause ){
        super(message,cause);
    }

}
