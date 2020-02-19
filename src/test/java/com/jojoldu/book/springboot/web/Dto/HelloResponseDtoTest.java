package com.jojoldu.book.springboot.web.Dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokFunctionTest(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        // assertj 라는 테스트 검증 라이브러리의 검증 메소드
        // 검증하고 싶은 대상을 메소드 인자로 받는다.
        // 메소드 체이닝이 지원되어 isEqualTo 와 같이 메소드를 이어서 사용가능.
        assertThat(dto.getAmount()).isEqualTo(amount);
                                    // assertj의 동등 비교 메소드 입니다.
                                    // assertThat에 있는 값과 isEqualTo의 값을 비교해서 값을 때에만 성공.

        /* Junit 의 기본 assertThat 이 아닌 assertj의 assertThat 을 사용한 이유는?

           1. CoreMatchers 와 달리 추가적으로 라이브러리 필요하지 않는다.
              ( Junit 의 assertThat을 쓰게 되면 is()와 같이 CoreMatchers 라이브러리가 필요하다. )

           2. 자동완성이 좀 더 확실하게 지원된다.
              ( IDE에서는 CoreMatchers 와 같은 Matcher 라이브러리의 자동완성 지원이 약함. )

              자세한 사항은 백기선님 동영상 참고할것.
        */
    }

}
