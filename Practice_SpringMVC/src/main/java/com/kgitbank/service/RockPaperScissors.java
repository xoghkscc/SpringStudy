package com.kgitbank.service;

import org.springframework.stereotype.Component;

//�������� root-context�� ������Ʈ�μ� ����� ��
@Component
public class RockPaperScissors {
//	����, ����, �� �� �ϳ��� �Է¹����� ��/��/�� ����� ���ϵǴ� �޼��带 �ϳ� �ۼ�
	public String game() {
		int num = (int) (Math.random()*3);
		if(num == 1) {
			return "��";
		}else if(num == 2) {
			return "��";
		}else {
			return "��";
		}
	}
//	JUnit �׽�Ʈ�� �޼��带 20ȸ �׽�Ʈ�ϰ� ���Ͽ� �޼��� ���� ����� ���� �α׸� ���ܺ���
}
