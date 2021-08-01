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
	
	//practice/hello/minsu or 민수 일때 작동하며 views/hello/minsu.jsp로 포워딩함
	@RequestMapping(value = {"/minsu", "/민수"}, 
			method = {RequestMethod.GET, RequestMethod.POST} ) 
	public String minsu() {
		log.info("minsu controller에 도착");
		
		return "hello/minsu";//view/hello/minsu.jsp로 보내는 걸 의미
	}
	
	
	//practice/hello/chulsu 일때 작동하며 views/hello/chulsu.jsp로 포워딩함
	@GetMapping("/chulsu")
	public void getChulsu(Human human,@RequestParam("taset") ArrayList<String> taset) {
		log.info("get chulsu controller에 도착");
		log.info("name: "+ human.getName());
		log.info("age: "+ human.getAge());
		log.info(taset);
		//그러나 Spring에서는 이렇게 해도 파라미터가 받아짐
	}
//	@GetMapping("/chulsu")
//	public void getChulsu(HttpServletRequest request) {
//		log.info("get chulsu controller에 도착");
//		log.info("name: "+ request.getParameter("name"));
//		//원래는 이렇게 request를 전달받아 이렇게 써야 하는게 옛날 방식
//	}
	
	@RequestMapping("/choosinsu")
	public String choo(Model model, Human human) {
		return "hello/choosinsu";
	}
	
	@GetMapping("/kim")
	public String kim() {
		//앞에 redirect:을 붙이면 뷰를 찾지 않고 리다이렉트를 응답
		return "redirect:/hello/choosinsu?name=김&age=321";
	}
}






















