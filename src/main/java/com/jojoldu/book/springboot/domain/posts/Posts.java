package com.jojoldu.book.springboot.domain.posts;


import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
// 클래스 내 모든 필드와 Getter 메소드를 자동생성
@NoArgsConstructor
// 기본 생성자 자동 추가
// public Posts() {} 와 같은 효과를 냅니다.
@Entity
// 테이블과 링크될 클래스 임을 나타낸다.
// 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭합니다.
// ex) SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity {

    @Id
    // 해당 테이블의 PK 필드를 나타냅니다. ( Primary key )
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK의 생성 규칙을 나타냅니다.
    // 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 가 됩니다.
    // 스프링 부트 2.0 버전과 1.5 버전의 차이를 알아보자.
    private Long id;

    @Column(columnDefinition = "TEXT", length = 500, nullable = false)
    // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
    // 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
    // 문자열의 경우 VARCHAR(255)가 기본 값인데, 사이즈를 500 으로 늘리고 싶거나 (ex:title)
    // (ex:content) 등의 경우에 사용합니다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    // 해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 상당에 선언 시 생상자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
