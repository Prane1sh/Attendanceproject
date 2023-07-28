package com.iamneo.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private int stu_id;
	private String stu_name;
	
	private String stu_gender;
	private long stu_phno;
	private String class_year;
	private String section;
	private String dept_name;
}

