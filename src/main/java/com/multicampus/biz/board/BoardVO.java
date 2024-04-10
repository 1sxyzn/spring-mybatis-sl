package com.multicampus.biz.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 테이블당 crud 기능을 하나씩 처리할 비즈니스 컴포넌트 필요. 4개의 자바파일로 구성.
// vo. dao(jdbc랑 연동). boardservice. boardserviceimpl(바즈니스 로직 담당. db 연동 필요. dao 객체 사용). 

// 1. VO(Value Object) 클래스
/*
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
*/
@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
}
