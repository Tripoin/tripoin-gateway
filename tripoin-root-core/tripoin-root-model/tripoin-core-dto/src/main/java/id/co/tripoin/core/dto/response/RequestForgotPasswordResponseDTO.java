package id.co.tripoin.core.dto.response;

import id.co.tripoin.core.dto.ResponseData;

import java.io.Serializable;

public class RequestForgotPasswordResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2816160355861457541L;
	
	private String token;
	private ResponseData responseData;
		
	public ResponseData getResponseData() {
		return responseData;
	}

	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
