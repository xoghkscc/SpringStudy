package com.kgitbank.gradeController;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgitbank.mapper.GradeMapper;
import com.kgitbank.model.Grade;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/grade")
public class gradeController {
	@Autowired
	GradeMapper gm;

	@RequestMapping("/crud")
	public String crud() {
		return "grade/CRUD";
	}

	@RequestMapping("/insertView")
	public String insertView() {
		return "grade/insert";
	}

	@RequestMapping("/insert")
	public String insert(Grade grade) {
		log.info(grade);
		gm.insertGrade(grade);
		return "grade/CRUD";
	}
	
	@RequestMapping("/select")
	public String select(Model model) {
		ArrayList<Grade> gradeList = gm.selectAllGrade();
		model.addAttribute("gradeList", gradeList);
		return "grade/select";
	}
	
	@RequestMapping("/search")
	public String search(Model model, Grade grade) {
		if(grade.getStudent_id() != null) {
			Grade g = gm.selectGrade(grade);
			ArrayList<Grade> gradeList = new ArrayList<Grade>();
			gradeList.add(g);
			model.addAttribute("gradeList", gradeList);
			
		} else {
			ArrayList<Grade> gradeList = gm.selectAllGrade();
			log.info(gradeList);
			model.addAttribute("gradeList", gradeList);
		}
		return "grade/select";
	}
	
	@RequestMapping("/updateView")
	public String update(Model model) {
		ArrayList<Grade> gradeList = gm.selectAllGrade();
		model.addAttribute("gradeList", gradeList);
		return "grade/update";
	}
	@RequestMapping("/update")
	public String update(Model model,Grade grade) {
		Grade g = gm.selectGrade(grade);
		model.addAttribute("updateGrade", g);
		
		return "grade/updateDetail";
	}
	@RequestMapping("/updateDb")
	public String updateDb(Grade grade) {
		gm.updateGrade(grade);
		return "grade/CRUD";
	}
	@RequestMapping("/deleteView")
	public String deleteView(Model model) {
		ArrayList<Grade> gradeList = gm.selectAllGrade();
		model.addAttribute("gradeList", gradeList);
		return "grade/delete";
	}
	
	@RequestMapping("/delete")
	public String delete(Grade grade) {
		gm.deleteGrade(grade.getStudent_id());
		return "grade/CRUD";
	}

}
