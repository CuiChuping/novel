package com.microc.novel.basic.util;

import java.util.List;

public class Pager<T> {

	private int index = 1;
	private int rowCount = 30;
	private int pageCount;
	private int totalCount;
	private List<T> result;

	public Pager(){ }
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = this.totalCount % rowCount == 0 ? (this.totalCount / rowCount) : (this.totalCount / rowCount + 1);
	}

	public int getFirstPage() {
		return 1;
	}

	public int getLastPage() {
		return pageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public List<T> getResult() {
		return result;
	}
	
	public void setResult(List<T> result) {
		this.result = result;
	}
	
	public int getPrevPage() {
		return this.index == 1 ? 1 : this.index - 1;
	}

	public int getNextPage() {
		return this.index > this.pageCount ? this.pageCount : this.index + 1;
	}
	
	public int getBeginRow() {
		return (index - 1) * rowCount;
	}

}
