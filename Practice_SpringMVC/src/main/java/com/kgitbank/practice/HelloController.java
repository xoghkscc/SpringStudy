package com.kgitbank.practice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgitbank.model.Human;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/hello/")
public class HelloController {
	
	//practice/hello/minsu or �μ� �϶� �۵��ϸ� views/hello/minsu.jsp�� ��������
	@RequestMapping(value = {"/minsu", "/�μ�"}, 
			method = {RequestMethod.GET, RequestMethod.POST} ) 
	public String minsu() {
		log.info("minsu controller�� ����");
		
		return "hello/minsu";//view/hello/minsu.jsp�� ������ �� �ǹ�
	}
	
	
	//practice/hello/chulsu �϶� �۵��ϸ� views/hello/chulsu.jsp�� ��������
	@GetMapping("/chulsu")
	public void getChulsu(Human human,@RequestParam("taset") ArrayList<String> taset) {
		log.info("get chulsu controller�� ����");
		log.info("name: "+ human.getName());
		log.info("age: "+ human.getAge());
		log.info(taset);
		//�׷��� Spring������ �̷��� �ص� �Ķ���Ͱ� �޾���
	}
//	@GetMapping("/chulsu")
//	public void getChulsu(HttpServletRequest request) {
//		log.info("get chulsu controller�� ����");
//		log.info("name: "+ request.getParameter("name"));
//		//������ �̷��� request�� ���޹޾� �̷��� ��� �ϴ°� ���� ���
//	}
	
	@RequestMapping("/choosinsu")
	public String choo(Model model, Human human) {
		return "hello/choosinsu";
	}
	
	@GetMapping("/kim")
	public String kim() {
		//�տ� redirect:�� ���̸� �並 ã�� �ʰ� �����̷�Ʈ�� ����
		return "redirect:/hello/choosinsu?name=��&age=321";
	}
}






















