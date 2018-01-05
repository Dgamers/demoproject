package com.demo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pojo.Customer;
import com.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class Demotest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void test1() {
		List<Customer> customers = customerService.selectByPage(1, 10, "D", "",
				"");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	@Test
	public void test2() {
		List<Customer> customers = customerService.selectByoffset(1, 10, "", "",
				"", "id desc");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
