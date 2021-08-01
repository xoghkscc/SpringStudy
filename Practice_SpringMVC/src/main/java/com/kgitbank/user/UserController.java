package com.kgitbank.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgitbank.model.UserInfo;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/join")
	public String main() {
		return "user/join";
	}
	
	
	@PostMapping("/controller")
	public String controller(UserInfo userInfo, Model model) {
		if(!(userInfo.getAge()== 0) & !(userInfo.getId().equals("")) & !(userInfo.getName().equals("")) 
				& !(userInfo.getPw().equals("")) & !(userInfo.getBirth().equals(""))) {
			log.error(userInfo);
			if(fileIO(userInfo)) {
				return "user/success";
			} else {
				return "user/false";
			}
		}else {
			return "user/false";
		}
	}
	
	public boolean fileIO(UserInfo userInfo) {
		log.info(String.format(application.getRealPath("/data/user/%s.txt"), userInfo.getId()));
		File file = new File(String.format(application.getRealPath("/data/user/%s.txt"), userInfo.getId()));
		if(!file.exists()) {
			try {
				BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				bout.write(userInfo.toString());
				bout.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	
}
