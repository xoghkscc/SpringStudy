package com.kgitbank.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserInfo {
	String id;
	String pw;
	String name;
	int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date birth;
	ArrayList<String> hobby;
}
