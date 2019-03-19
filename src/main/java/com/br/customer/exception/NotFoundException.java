package com.br.customer.exception;

public class NotFoundException  extends ApiException {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6330228300292363049L;
	
	private int code;
	 
	public NotFoundException (int code, String msg) {
	    super(404, msg);
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
