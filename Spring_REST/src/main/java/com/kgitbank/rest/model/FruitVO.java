package com.kgitbank.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FruitVO {
	private String name;
	private int price;
	private int calorie;
	
	public FruitVO() {
		name = "»ç°ú";
		price = 1500;
		calorie = 300;
	}
}
