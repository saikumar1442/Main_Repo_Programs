package com.programs.entity;

public class Employ {

	private String name;
	private double salary;
	public Employ(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
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
	@Override
	public String toString() {
		return "Employ [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
