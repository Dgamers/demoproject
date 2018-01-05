package com.utils;

import java.util.List;

public class Tableresult<T> {

	private List<T> rows;

	private Long total;

	public Tableresult(List<T> rows, Long total) {
		super();
		this.rows = rows;
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
