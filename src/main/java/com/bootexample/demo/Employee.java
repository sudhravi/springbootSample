package com.bootexample.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employee{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@Transient
	private Long dept_id;
	
	
	@ManyToOne
	
	private Department department;
	
	Employee(){
	}
	Employee(Long id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDept_id() {
		return this.department.getId();
	}
	

}