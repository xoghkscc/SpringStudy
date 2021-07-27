package com.kgitbank.service;

import org.springframework.stereotype.Component;

//스프링의 root-context에 컴포넌트로서 등록할 것
@Component
public class RockPaperScissors {
//	가위, 바위, 보 중 하나를 입력받으면 승/무/패 결과가 리턴되는 메서드를 하나 작성
	public String game() {
		int num = (int) (Math.random()*3);
		if(num == 1) {
			return "승";
		}else if(num == 2) {
			return "무";
		}else {
			return "패";
		}
	}
//	JUnit 테스트로 메서드를 20회 테스트하고 파일에 메서드 실행 결과에 대한 로그를 남겨보셈
}
