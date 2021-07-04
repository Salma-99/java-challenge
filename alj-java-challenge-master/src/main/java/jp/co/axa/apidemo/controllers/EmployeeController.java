package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok().body(employeeService.retrieveEmployees());

	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		System.out.println("Employee");
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping(value = "/employees", produces = "application/json")
	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		System.out.println("Employee Saved Successfully");
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
	}

	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
		}

	}

}
