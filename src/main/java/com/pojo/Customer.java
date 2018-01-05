package com.pojo;

public class Customer {

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private Integer sex;
	public String getEmail() {
		return email;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public Integer getSex() {
		return sex;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", sex=" + sex + "]";
	}

}
