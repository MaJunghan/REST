package com.example.restwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
    HTTP Status code
2XX - 성공
4XX - 클라이언트측 에러
5XX - 서버
5백번대 > 4백번대로 변경하고 싶어
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
