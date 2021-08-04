package com.kgitbank.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.rest.model.FruitVO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class RestSampleController {
	
	@GetMapping(value = "/getstr", produces = "text/plain; charset=UTF-8")
	public String getString() {
		return "안녕하세요 REST컨트롤러 입니다.";
	}
	
	@GetMapping(value = "/getstr2", produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8")
	public String getString2() {
		return "한글이야 안녕?";
	}
	
	@GetMapping(value = "/getstr3", produces = MediaType.TEXT_HTML_VALUE)
	public String getString3() {
		return "Hello Rest!";
	}
	
	@GetMapping(value = "getSample", produces = MediaType.APPLICATION_JSON_VALUE)
	public FruitVO getSampleObject() {
		return new FruitVO();
	}
	
	@GetMapping(value = "getSampleXML", produces = MediaType.APPLICATION_XML_VALUE)
	public FruitVO getSampleObjectxml() {
		return new FruitVO();
	}
	
	
}
