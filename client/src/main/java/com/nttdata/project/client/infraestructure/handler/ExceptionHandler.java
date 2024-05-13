package com.nttdata.project.client.infraestructure.handler;

import com.nttdata.project.client.application.dto.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ClientResponse> handlerException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(ClientResponse.builder()
                .code("400")
                .message(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
