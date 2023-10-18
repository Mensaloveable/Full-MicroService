package com.loveable.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Setter
@Getter
@ResponseStatus(HttpStatus.CONFLICT)
public class InstanceAlreadyExistException extends RuntimeException {
    public InstanceAlreadyExistException(String message) {
        super(message);
    }
}
