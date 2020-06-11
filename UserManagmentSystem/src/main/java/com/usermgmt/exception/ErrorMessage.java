package com.usermgmt.exception;

import java.util.Date;

public class ErrorMessage {
	
	private int errorCode;
	private String errorMsg;
	private Date date;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ErrorMessage() {
		super();
		
	}
	public ErrorMessage(int errorCode, String errorMsg, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.date = date;
	}
	

}
