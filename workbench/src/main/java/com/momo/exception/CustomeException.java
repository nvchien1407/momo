package com.momo.exception;
public class CustomeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String errCode;

	public CustomeException(String errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}
}
