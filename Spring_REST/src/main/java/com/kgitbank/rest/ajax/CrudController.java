package com.kgitbank.rest.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud")
public class CrudController {
	@GetMapping("main")
	public String mainView() {
		return "ajax/CRUD_home";
	}
	
}
