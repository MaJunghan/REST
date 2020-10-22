
package com.example.restwebservice.Exception;


import com.example.restwebservice.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // 파라미터로받아온 익셉션이 실행됬을때 이메소드를 실행하겠다.
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) { // 여기객체
        //발생했던에러객체 , 어디서발생했는지를 파라미터로받아오겠다
        //앞에서 만든 익셉션리스폰스
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class) // 앞서정의한 저익셉션이 발생하면 이메소드를 실행하겠다.
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        //발생했던에러객체 , 어디서발생했는지를 파라미터로받아오겠다
        //앞에서 만든 익셉션리스폰스
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                "Validation Failed", ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}

