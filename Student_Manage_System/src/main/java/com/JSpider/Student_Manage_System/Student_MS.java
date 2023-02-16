package com.JSpider.Student_Manage_System;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Student_MS 
{
	@Id
	@Column
	private Integer Student_Id;
	@Column
	private String Student_Name;
	@Column
	private Double Student_Perc;
	public Integer getStudent_Id() {
		return Student_Id;
	}
	public void setStudent_Id(Integer student_Id) {
		this.Student_Id = student_Id;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.Student_Name = student_Name;
	}
	public Double getStudent_Perc() {
		return Student_Perc;
	}
	public void setStudent_Perc(Double student_Perc) {
		this.Student_Perc = student_Perc;
	}
	 
}
