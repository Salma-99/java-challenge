package jp.co.axa.apidemo.util;

import org.springframework.stereotype.Component;
import jp.co.axa.apidemo.beans.response.EmployeeRecordResponse;
import jp.co.axa.apidemo.entities.Employee;

@Component
public class Utility {

    public EmployeeRecordResponse employeeRecordResponseMapper(Employee employee) {
    	EmployeeRecordResponse employeeRecordResponse = new EmployeeRecordResponse();
    	employeeRecordResponse.setId(employee.getId());
    	employeeRecordResponse.setName(employee.getName());
    	employeeRecordResponse.setSalary(employee.getSalary());
    	employeeRecordResponse.setDepartment(employee.getDepartment());
        return employeeRecordResponse;
    }

}
