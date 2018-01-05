package com.service;

import java.util.List;

import com.pojo.Customer;

public interface CustomerService {

	List<Customer> selectByoffset(int offset, int PageSize, String search_name,
			String search_phone, String search_email, String order_words);
	List<Customer> selectByPage(int Pagenum, int PageSize, String search_name,
			String search_phone, String search_email);
}
