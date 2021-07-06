package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.beans.request.EmployeeRequest;
import jp.co.axa.apidemo.beans.response.EmployeeRecordResponse;
import jp.co.axa.apidemo.beans.response.EmployeeResponse;
import jp.co.axa.apidemo.constant.ConstantString;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	EmployeeResponse employeeResponse;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok().body(employeeService.retrieveEmployees());

	}

	@GetMapping(value = "/employees/{employeeId}")
	public EmployeeRecordResponse getEmployee(@Valid @RequestParam(name = "employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest, BindingResult result) {
		String response = null;
		try {
			if (result.hasErrors()) {
				employeeResponse.setMessage(ConstantString.NULLVALUE);
				return employeeResponse;
			}
			response = employeeService.saveEmployee(employeeRequest);
		} catch (Exception e) {
			System.out.println(ConstantString.FAILTOSAVE + e.toString());
		}
		employeeResponse.setMessage(response);
		return employeeResponse;
	}

	@DeleteMapping("/employees/{employeeId}")
	public EmployeeResponse deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		String response = employeeService.deleteEmployee(employeeId);
		employeeResponse.setMessage(response);
		return employeeResponse;
	}

	@PutMapping("/employees/{employeeId}")
	public EmployeeResponse updateEmployee(@RequestBody Employee employee,
			@PathVariable(name = "employeeId") Long employeeId) {
		String response = employeeService.updateEmployee(employee);
		employeeResponse.setMessage(response);
		return employeeResponse;

	}

}
