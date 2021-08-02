package com.kgitbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Department {
	@NonNull
	private Integer department_id;
	private String department_name;
	@NonNull
	private Integer manager_id;
	@NonNull
	private Integer location_id;
}
