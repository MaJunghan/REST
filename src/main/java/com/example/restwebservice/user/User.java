package com.example.restwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
   @Id
   @GeneratedValue
   private Integer id; // 아이디

   @Size(min=2, message = "name은 2글자이상 입력해주세요") // 최소글자수가 2글자이상
   private String name; // 이름
   @Past // 미래데이터쓸수없고 과거날자만쓸수있음
   private Date joinDate; //가 입일자
   private String passwd; // 비밀번호
   private String ssn; // 주민번호

   @OneToMany(mappedBy = "user")
   private List<Post> posts;

   public User(int id, String name, Date JoinDate, String password, String ssn) {
      this.id = id;
      this.name = name;
      this.joinDate = joinDate;
      this.passwd = passwd;
      this.ssn = ssn;
   }
}
