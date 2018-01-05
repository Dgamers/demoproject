package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerMapper;
import com.github.pagehelper.PageHelper;
import com.pojo.Customer;
import com.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	public List<Customer> selectByoffset(int offset, int PageSize,
			String search_name, String search_phone, String search_email,
			String order_words) {
		PageHelper.offsetPage(offset, PageSize, true);
		List<Customer> customers = customerMapper.selectByoffset(search_name,
				search_phone, search_email, order_words);
		if (customers.size() != 0) {
			return customers;
		}
		return null;
	}

	public List<Customer> selectByPage(int Pagenum, int PageSize,
			String search_name, String search_phone, String search_email) {
		PageHelper.startPage(Pagenum, PageSize, true);
		List<Customer> customers = customerMapper.selectByPage(search_name,
				search_phone, search_email);
		if (customers.size() != 0) {
			return customers;
		}
		return null;
	}

}
