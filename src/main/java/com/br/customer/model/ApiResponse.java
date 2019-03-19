package com.br.customer.model;

public class ApiResponse {

	  public static final int ERROR = 1;
	  public static final int WARNING = 2;
	  public static final int INFO = 3;
	  public static final int OK = 4;
	  public static final int TOO_BUSY = 5;

	  int code;
	  String type;
	  String message;
	
	  public ApiResponse(){}
	  
	  public ApiResponse(int code, String message){
	    this.code = code;
	    switch(code){
	    case ERROR:
	      setType("error");
	      break;
	    case WARNING:
	      setType("warning");
	      break;
	    case INFO:
	      setType("info");
	      break;
	    case OK:
	      setType("ok");
	      break;
	    case TOO_BUSY:
	      setType("too busy");
	      break;
	    default:
	      setType("unknown");
	      break;
	    }
	    this.message = message;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	  
}
