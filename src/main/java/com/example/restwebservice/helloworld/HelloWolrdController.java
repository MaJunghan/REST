package com.example.restwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWolrdController {
    // GET
    //  /hello-world (endpoint) : 클라이언트가 요청하는 Url  > 서버가 처리해서 결과값을 넘겨주면됨.
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world") : 새는 바로 get인지 post인지 표시하는 get맵핑사용

    @GetMapping("/hello-world")
    public String helloworld()  {
        return "Hello world";
    }

    // alt + enter
    @GetMapping("/hello-world-bean")
    public HelloworldBean helloworldBean()  {
        return new HelloworldBean("이거실화냐 ?");
    }


    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloworldBean helloworldBean(@PathVariable String name)  {
        return new HelloworldBean(String.format("Hello world,%s", name));
    }



}
