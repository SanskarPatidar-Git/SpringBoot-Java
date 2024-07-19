package com.tutorial.springframework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "emp")
public class EmpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name" , nullable = false)
	private String name;
	
	@Column(name = "salary" , nullable = false)
	private double salary;
	
	@Column(name = "number")
	private String number;
	
	public EmpEntity() {
		
	}

	public EmpEntity(String name, double salary, String number) {
		this.name = name;
		this.salary = salary;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "EmpEntity [id=" + id + ", name=" + name + ", salary=" + salary + ", number=" + number + "]";
	}
}
