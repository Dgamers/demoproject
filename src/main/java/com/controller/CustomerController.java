package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.pojo.Customer;
import com.service.CustomerService;
import com.utils.DataTablesView;
import com.utils.Tableresult;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getcustomers", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getcustomers(
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(name = "search_name", required = false) String search_name,
			@RequestParam(name = "search_phone", required = false) String search_phone,
			@RequestParam(name = "search_email", required = false) String search_email) {
		List<Customer> customers = customerService.selectByPage(pageNumber,
				pageSize, search_name, search_phone, search_email);
		PageInfo<Customer> info = new PageInfo<Customer>(customers);
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		return JSON.toJSONString(
				new Tableresult<Customer>(customers, info.getTotal()));
	}

	@RequestMapping(value = "/getdatas", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getdatas(
			@RequestParam(name = "start", required = false, defaultValue = "0") Integer offset,
			@RequestParam(name = "length", required = false, defaultValue = "10") Integer pagesize,
			Integer draw, HttpServletRequest request,
			@RequestParam(name = "search_name", required = false) String search_name,
			@RequestParam(name = "search_phone", required = false) String search_phone,
			@RequestParam(name = "search_email", required = false) String search_email) {
		String order = request.getParameter("order[0][column]");// ÅÅÐòµÄÁÐºÅ
		String orderDir = request.getParameter("order[0][dir]");// ÅÅÐòµÄË³Ðòasc or
																// desc
		String orderColumn = request
				.getParameter("columns[" + order + "][data]");
		System.out.println(search_name);
		List<Customer> customers = customerService.selectByoffset(offset,
				pagesize, search_name, search_phone, search_email,
				orderColumn + " " + orderDir);
		PageInfo<Customer> info = new PageInfo<Customer>(customers);
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		return JSON.toJSONString(new DataTablesView<Customer>(customers,
				info.getTotal(), info.getTotal(), draw));
	}
}
