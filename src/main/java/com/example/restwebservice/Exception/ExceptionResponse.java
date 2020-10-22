
package com.example.restwebservice.Exception;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Data: 셋터, 겟터 자동생성
// AllArgsConstructor : 파라미터 받는생성자.
// NoArgsConstructor: 파라미터 없는생성자
// 생성자가 자동으로 생성되므로써 자동으로 메모리에 올려줌 > 사용할수있는 객체가되는것임.
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}

