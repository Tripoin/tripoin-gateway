package com.tripoin.util.exception;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class UsernameFaultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4604852139725663540L;
	private String message;

	public UsernameFaultException(String message) {
		super(message);
		this.message = message;
	}

	public UsernameFaultException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
