package com.example.demo.exception;

import java.util.Date;

public class ErrorDetails {

	
	
	private Date timeStamp;
	private String message;
	private String detail;
	
	//constructor
	public ErrorDetails(Date timeStamp, String message, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
	}
	
	//getter setter
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
