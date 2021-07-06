package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.beans.request.EmployeeRequest;
import jp.co.axa.apidemo.beans.response.EmployeeRecordResponse;
import jp.co.axa.apidemo.entities.Employee;
import java.util.List;

public interface EmployeeService {

    public List<Employee> retrieveEmployees();

    public EmployeeRecordResponse getEmployee(Long employeeId);

    public String saveEmployee(EmployeeRequest employeeRequest);

    public String deleteEmployee(Long employeeId);

    public String updateEmployee(Employee employee);
}