package com.weblearner.springboot;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weblearner.springboot.model.Employee;
import com.weblearner.springboot.service.EmployeeService;

@Service
@Path("/weblearner")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GET
	@Path("/ping")
	@Produces("text/plain")
	public String ping() {
		return "Ping is working";
	}

	@GET
	@Path("/employee/{id}")
	@Produces("application/json")
	public Employee getEmployee(@PathParam("id") String id) {
		System.out.println("Employee Id -->" + id);
		return service.getEmployee(id);
	}

	@POST
	@Path("/employee")
	@Produces("text/plain")
	@Consumes("application/json")
	public String addEmployee(Employee emp) {
		return service.addEmployee(emp);
	}

	@PUT
	@Path("/employee/{id}")
	@Produces("text/plain")
	@Consumes("application/json")
	public String updateEmployee(@PathParam("id") String id, @QueryParam("dept") String dept) {
		return service.updateEmployeeDept(id, dept);
	}
	
	
	@DELETE
	@Path("/employee/{id}")
	@Produces("text/plain")
	public String deleteEmployee(@PathParam("id") String id) {
		return service.deleteEmployee(id);
	}

}
