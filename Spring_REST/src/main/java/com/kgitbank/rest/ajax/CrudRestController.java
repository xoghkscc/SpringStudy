package com.kgitbank.rest.ajax;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.grade.mapper.GradeMapper;
import com.kgitbank.model.Grade;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/crud_rest")
public class CrudRestController {
	@Autowired
	GradeMapper gm;
	
	@GetMapping(value = "/getGrade", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Grade> getString() {
		
		return gm.selectAllGrade();
	}
	
	@PostMapping(value = "/deleteGrade", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteGrade(@RequestBody String student_id) {
		gm.deleteGrade(Integer.parseInt(student_id));
	}
	
	@PostMapping(value = "/insertGrade", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertGrade(@RequestBody Grade grade) {
		gm.insertGrade(grade);
	}
}
