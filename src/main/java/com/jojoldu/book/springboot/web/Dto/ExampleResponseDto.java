package com.jojoldu.book.springboot.web.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class ExampleResponseDto {

    private final String name;
    private final int age;

    /*
    public ExampleResponseDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
    */

}
