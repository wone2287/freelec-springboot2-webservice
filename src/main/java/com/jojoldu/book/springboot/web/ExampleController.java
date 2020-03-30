package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.Dto.ExampleResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/")
    public ExampleResponseDto Example(@RequestParam String name, @RequestParam int age){
        return new ExampleResponseDto(name, age);
    }

    @GetMapping("/add/{id}")
    public int add(@PathVariable int id){
        int sum = id + 10;
        return sum;
    }
}
