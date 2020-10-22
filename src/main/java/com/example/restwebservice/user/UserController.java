package com.example.restwebservice.user;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service; // 전역변수사용

    // 생성자 방식으로 의존성주입 -> this
    public UserController(UserDaoService service) {
        this.service = service;
    }

    // 전체 회원조회 서비스 호출
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // 특정회원 조회 서비스호출
    @GetMapping("users/{id}") //가변변수로 값을받아서 Url을받겠다 // id값
    public User retrieveUser(@PathVariable int id) { // 사용자가 입력하는값은 서버에서 문자로받아들이는데,이것을 자동으로 컨버팅해줌.
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not fount",id));
        }

        return user;
    }

    // 회원목록 추가
    @PostMapping("/users") // post요청시 이 메소드실행
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // 회원삭제
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) { // 패스베리어블 id값을 파라미터로 가져오기위해서 어노테이션.
        User user = service.deleteById(id);

        if(user == null) { // 삭제되지않았다.
            throw new UserNotFoundException(String.format("ID[%s] not fount", id));
        }
    }
}
