package com.microc.novel.basic.model;

import java.util.Date;

public class Suggestion {
	
	private String id;
	/**
	 * 联系方式
	 * */
	private String contactWay;
	/**
	 * 意见建议
	 * */
	private String suggestion;
	/**
	 * 创建时间
	 * */
	private Date createTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContactWay() {
		return contactWay;
	}
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
