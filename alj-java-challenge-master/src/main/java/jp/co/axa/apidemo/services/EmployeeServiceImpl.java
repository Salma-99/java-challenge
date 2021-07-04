package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.ResourceNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		if (optEmp.isPresent()) {
			return optEmp.get();
		} else {
			throw new ResourceNotFoundException("Employee Recored Not Found. Id: " + employeeId);
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Optional<Employee> optGetEmp = employeeRepository.findById(employeeId);
		if (optGetEmp.isPresent()) {
			employeeRepository.deleteById(employeeId);
		} else {
			throw new ResourceNotFoundException("Employee Recored Not Found. Id: " + employeeId);
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

		Optional<Employee> optGetEmp = employeeRepository.findById(employee.getId());
		if (optGetEmp.isPresent()) {
			Employee empUpdate = optGetEmp.get();
			empUpdate.setId(employee.getId());
			empUpdate.setName(employee.getName());
			empUpdate.setSalary(employee.getSalary());
			empUpdate.setDepartment(employee.getDepartment());
			employeeRepository.save(employee);
		} else {
			throw new ResourceNotFoundException("Employee Recored Not Found. Id: " + employee.getId());
		}

	}

}