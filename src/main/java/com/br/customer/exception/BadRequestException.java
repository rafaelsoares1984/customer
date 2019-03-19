package com.br.customer.exception;

public class BadRequestException  extends ApiException {
	
	/**
	* Serial Version UID 
	*/
	private static final long serialVersionUID = -4853579994735819570L;
	
	private int code;
	public BadRequestException (int code, String msg) {
	    super(code, msg);
	    this.code = code;
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
