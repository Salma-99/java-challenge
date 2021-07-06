package jp.co.axa.apidemo.repositories;

import jp.co.axa.apidemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
    @Query(value = "SELECT *  FROM EMPLOYEE  WHERE id = ?1", nativeQuery = true)
    Employee getById(Long employeeId);


}
