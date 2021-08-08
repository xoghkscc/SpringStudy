package com.kgitbank.rest.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/cookie/")
@Controller
public class CookieController {
	
	@GetMapping("/login")
	public String login(String id, String password,Model model ,HttpServletResponse response) {
		if(id.equals("abcd") && password.equals("1234")) {
			response.addCookie(new Cookie("login", "1"));
			log.info("로그인 성공");
		} else {
//			쿠키 삭제하기
			Cookie cookie = new Cookie("id", "");
			cookie.setMaxAge(0);
			log.info("로그인 실패");
		}
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		response.addCookie(new Cookie("id", id));
		response.addCookie(new Cookie("password", password));
		return "cookie/login";
	}
	
	@GetMapping("read_all_cookie")
	public String readAllCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println("name: "+cookie.getName());
				System.out.println("value: "+cookie.getValue());
			}
		}
		return "/cookie/check";
	}
	
	@GetMapping("/check")
	public void check(
			@CookieValue(value = "id", defaultValue = "비회원") String id,
			@CookieValue(value = "login", defaultValue = "0") String login,
			Model model
	) {
		model.addAttribute("id", id);
		model.addAttribute("login", login);
	}
	
	
	
	
	
	
}
