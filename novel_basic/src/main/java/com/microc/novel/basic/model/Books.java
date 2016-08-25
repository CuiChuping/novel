package com.microc.novel.basic.model;

import java.util.Date;

public class Books {

	private String id;
	
	private String name;
	
	private String categoryId;
	
	private String author;
	
	private Long wordCount;
	
	private Date updateDate;
	
	private Integer status;
	
	private String imagePath;

	private String desc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getWordCount() {
		return wordCount;
	}

	public void setWordCount(Long wordCount) {
		this.wordCount = wordCount;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", author=" + author
				+ ", wordCount=" + wordCount + ", updateDate=" + updateDate + ", status=" + status + ", imagePath="
				+ imagePath + ", desc=" + desc + "]";
	}
	
}
