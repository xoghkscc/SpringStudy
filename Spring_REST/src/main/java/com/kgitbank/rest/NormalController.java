package com.kgitbank.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/normal")
@Controller
public class NormalController {
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute(1236);
		model.addAttribute("abc");
		model.addAttribute(123.1234);
		model.addAttribute("flavor", "»ç°ú¸À");
		
		return "/home";
	}
}
