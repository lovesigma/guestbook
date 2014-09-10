package com.nhnent.guestbook.model;

import java.sql.Date;

public class GuestBook {
	private String content;
	private String email;
	private String password;
	private Date createDate;
	private Date changeDate;
	public GuestBook(String email,String password,String content,Date createDate) {
		this.email = email;
		this.password = password;
		this.content = content;
		this.createDate = createDate;
	}
	public GuestBook() {
	}
	public GuestBook(String email,String password,String content) {
		this.email = email;
		this.password = password;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
}
