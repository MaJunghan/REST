package com.example.restwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired
    UserRepository userRepository; // UserRepository를 사용하겠다.

    @Autowired
    PostRepository postRepository;


    @GetMapping("/users") // 리퀘스트맵핑하면 앞에공통으로들어가는 jpa생략.
    public List<User> retrieveAllUsers() {
        return userRepository.findAll(); // UserRepository를 JpaRepository에 정의되있어서바로그냥사용하면됨.
    }

    @GetMapping("/users/{id}")
    public User rertieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // POST조회
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        return user.get().getPosts();
    }

    // 게시글 추가
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id,@RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
