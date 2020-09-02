package com.weblearner.springboot.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String empId;
	private String empName;
	private String deptName;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String toString() {
		return "Employee Id: " + this.empId + "Employee Name: " + this.empName + "Employee Dept Name: " + this.deptName;
	}

}
