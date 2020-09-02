package com.weblearner.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.weblearner.springboot.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	private static List<Employee> employeeLst = new ArrayList<>();

	@Override
	public Employee getEmployee(String empId) {
		Stream<Employee> empStream = employeeLst.stream().filter(emp -> {
			return emp.getEmpId().equalsIgnoreCase(empId);
		});
		return empStream.findAny().get();
	}

	@Override
	public String addEmployee(Employee e) {
		employeeLst.add(e);
		return "Success";
	}

	@Override
	public String updateEmployeeDept(String empId, String deptName) {

		employeeLst.stream().forEach(emp -> {
			if (emp.getEmpId().equalsIgnoreCase(empId)) {
				emp.setDeptName(deptName);
			}
		});

		return "SUCCESS";
	}

	@Override
	public String deleteEmployee(String empId) {
		System.out.println("Employee Id -->"+ empId);
		if (employeeLst.removeIf(emp -> emp.getEmpId().equalsIgnoreCase(empId)))
			return "SUCCESS";
		else
			return "FAIURE";
	}

	static {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		// employee 1
		emp1.setEmpId("A1234");
		emp1.setEmpName("Sam");
		emp1.setDeptName("IT");
		// employee 2
		emp2.setEmpId("B1234");
		emp2.setEmpName("Tom");
		emp2.setDeptName("Finance");

		employeeLst.add(emp1);
		employeeLst.add(emp2);
	}

}
