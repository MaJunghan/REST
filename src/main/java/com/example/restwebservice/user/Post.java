package com.example.restwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id // 기본키설정
    @GeneratedValue // 1씩증가
    private Integer id;

    private  String desription; // 내용

    @ManyToOne(fetch = FetchType.LAZY) // post글은 여러개인데 매칭될메인은 user 하나라서 ManyToOne
    @JsonIgnore
    private User user;
}
