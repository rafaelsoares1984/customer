package com.br.customer.exception;

public class ApiException  extends Exception {
	
	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 1254323170155327008L;
	
	private int code;
	
	public ApiException (int code, String msg) {
	   super(msg);
	   this.setCode(code);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
}
