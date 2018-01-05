package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Customer;

public interface CustomerMapper {

	List<Customer> selectByoffset(@Param("search_name") String search_name,
			@Param("search_phone") String search_phone,
			@Param("search_email") String search_email,
			@Param("order_words") String order_words);
	List<Customer> selectByPage(@Param("search_name") String search_name,
			@Param("search_phone") String search_phone,
			@Param("search_email") String search_email);
}
