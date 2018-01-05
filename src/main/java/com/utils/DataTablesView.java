package com.utils;

import java.util.List;

public class DataTablesView<T> {
	private List<T> data;
	private long recordsTotal;
	private long recordsFiltered;
	private int draw;

	public DataTablesView(List<T> data, long recordsTotal, long recordsFiltered,
			int draw) {
		super();
		this.data = data;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.draw = draw;
	}
	public List<T> getData() {
		return data;
	}
	public int getDraw() {
		return draw;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

}
