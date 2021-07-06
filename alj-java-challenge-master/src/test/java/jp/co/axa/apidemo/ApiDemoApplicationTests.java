package jp.co.axa.apidemo;

import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import jp.co.axa.apidemo.beans.response.EmployeeResponse;
import jp.co.axa.apidemo.controllers.EmployeeController;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@InjectMocks
	EmployeeController employeeController;
	@Mock
	EmployeeRepository employeeRepository;
	
	@Mock
	EmployeeService employeeService;

	@Mock
	EmployeeResponse response;

	@Mock
	BindingResult result;

	@Before(value = "")
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

}
