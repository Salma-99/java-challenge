package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.beans.request.EmployeeRequest;
import jp.co.axa.apidemo.beans.response.EmployeeRecordResponse;
import jp.co.axa.apidemo.constant.ConstantString;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.util.Utility;
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

	@Autowired
	public Utility utility;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public EmployeeRecordResponse getEmployee(Long employeeId) {
		Employee employee = employeeRepository.getById(employeeId);
		if (null != employee) {
			return utility.employeeRecordResponseMapper(employee);
		}
		return new EmployeeRecordResponse();
	}

	@Override
	public String saveEmployee(EmployeeRequest employeeRequest) {
		try {
			Employee employee = new Employee();
			employee.setName(employeeRequest.getName());
			employee.setSalary(employeeRequest.getSalary());
			employee.setDepartment(employeeRequest.getDepartment());
			employeeRepository.save(employee);
			return ConstantString.RECORDCREATED;
		} catch (Exception e) {
			e.printStackTrace();
			return ConstantString.FAILTOCREATERECORD;
		}

	}

	@Override
	public String deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.getById(employeeId);
		if (null != employee) {
			employeeRepository.deleteById(employeeId);
			return ConstantString.RECORDDELETED + employeeId;
		}
		return ConstantString.RECORDNOTEXITS + employeeId;
	}

	@Override
	public String updateEmployee(Employee employee) {
		Optional<Employee> optGetEmp = employeeRepository.findById(employee.getId());
		if (optGetEmp.isPresent()) {
			Employee empUpdate = optGetEmp.get();
			empUpdate.setId(employee.getId());
			empUpdate.setName(employee.getName());
			empUpdate.setSalary(employee.getSalary());
			empUpdate.setDepartment(employee.getDepartment());
			employeeRepository.save(employee);
			return ConstantString.RECORDUPDATED + employee.getId();
		} else {
			return ConstantString.RECORDNOTEXITS + employee.getId();
		}

	}

}