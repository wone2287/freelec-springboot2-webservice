package com.jojoldu.book.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// test 를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
// 여기서 SpringRunner 라는 스프링 실행자를 사용함
// 스프링 부트 테스트와 Junit 사이에 연결자 역할을 함
@WebMvcTest(controllers = HelloController.class)
// 여러 스프링 테스트 어노테이션 중 Web(spring MVC)에 집중할 수 있는 어노테이션
// 선언할 경우 @Controller @ControllerAdvice 등는 사용 가능
// 단, @Service, @Component, @Repository 등은 사용 불가능
// 여기서는 컨트롤러만 사용하기 때문에 선언함.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입 받음
    private MockMvc mvc;
    // 웹 API 를 테스트할 때 사용.
    // 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음.


    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                // MockMvc 를 통해 /hello 주소로 HTTP GET 요청을 함
                // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있음.
                .andExpect(status().isOk())
                // mvc.perform의 결과를 검증함
                // HTTP Header의 Status 를 검증함
                // 우리가 흔히 알고있는 200, 404, 500 등의 상태를 검증
                // 여기선 OK, 즉 200이 아닌지 검증
                .andExpect(content().string(hello));
                // mvc.perform의 결과를 검증합니다.
                // 응답 본문의 내용을 검증합니다
                // Controller 에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증
    }
}
