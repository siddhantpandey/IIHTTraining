package com.verizon.sju;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.sju.controller.CustomerController;
import com.verizon.sju.model.Customer;
import com.verizon.sju.service.ICustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)

public class CustomerControllerTest {

	private MockMvc mockmvc;
	
	@MockBean
	private ICustomerService empServiceMock;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockmvc = null;
	}

	@Test
	public void testListCustomers() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		List<Customer> empList = new ArrayList<>();
		empList.add(new Customer());

		when(empServiceMock.listCustomers()).thenReturn(empList);

		mockmvc.perform(get("/listEmps")).andExpect(status().isOk()).andExpect(view().name("empList"))
				.andExpect(model().attributeExists("emps")).andExpect(model().attribute("emps", empList))
				.andDo(print());
	}

	@Test
	public void testIsPostNotListCustomers() throws Exception {
		this.mockmvc.perform(post("/listEmps")).andExpect(status().is4xxClientError());

	}

}
