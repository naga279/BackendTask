package com.usermgmt.exception;

public class NoUserExistsException extends RuntimeException{
	
	public NoUserExistsException(String msg) {
		super(msg);
	}

}
