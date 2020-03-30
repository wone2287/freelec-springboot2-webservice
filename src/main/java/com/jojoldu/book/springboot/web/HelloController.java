package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.Dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 컨트롤러를 JSON을 반환하는 컨트롤러를 만들어줌.
public class HelloController {

    @GetMapping("/hello")
    // HTTP Method 인 Get의 요청을 받을 수 있는 API 를 만들어 줍니다.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션임.
        // 여기서는 외부에서 name (@RequestParam("name")) 이란 이름으로 넘긴 파라미터
        // 를 메소드 파라미터 name(String name)에 저장하게 됩니다.
        return new HelloResponseDto(name, amount);
    }


}
