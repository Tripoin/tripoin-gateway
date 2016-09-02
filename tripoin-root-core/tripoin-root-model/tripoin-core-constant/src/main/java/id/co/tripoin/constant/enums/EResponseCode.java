package id.co.tripoin.constant.enums;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EResponseCode {

	RC_SUCCESS(200, "T-000", "Web Service Success"),
	RC_LOGOUT_SUCCESS(200, "T-001", "Logout Success"),

	RC_BAD_REQUEST(400, "T-QQQ", "Web Service Bad Request"),
	RC_BAD_CREDENTIALS(401, "T-Q01", "Web Service Bad Credentials"),
	RC_INVALID_TOKEN(401, "T-Q02", "Web Service Invalid Access Token"),	
	RC_UNAUTHORIZED(401, "T-Q03", "Web Service Unauthorized"),	
	RC_ACCESS_DENIED(403, "T-Q04", "Web Service Access is denied"),
	RC_BAD_TRIPOIN_KEY(400, "T-Q05", "Invalid X-Tripoin-Key"),
	RC_BAD_TRIPOIN_TIMESTAMP(400, "T-Q06", "Invalid X-Tripoin-Timestamp (ISO8601)"),
	RC_BAD_TRIPOIN_SIGNATURE(400, "T-Q07", "Invalid X-Tripoin-Signature"),
	RC_USERNAME_EXISTS(409, "T-Q08", "Username already exists, please try others!"),
	RC_USERNAME_NOT_EXISTS(404, "T-Q09", "Username not exsits"),
	RC_FAIL_PASSWORD(400, "T-Q10", "Invalid Password"),
	RC_EMAIL_EXISTS(409, "T-Q11", "Email already exists, please try others!"),
	RC_EMAIL_NOT_EXISTS(404, "T-Q12", "Email is not registered"),
	RC_PHONE_EXISTS(409, "T-Q12", "Phone No. already exists, please try others!"),
	RC_PHONE_NOT_EXISTS(404, "T-Q13", "Phone No. not exists!"),
	RC_GENDER_NOT_DEFINE(404, "T-Q14", "Gender Not Define"),
	RC_ACCOUNT_EXPIRED(410, "T-Q15", "Account is expired"),
	RC_ACCOUNT_NOTACTIVE(410, "T-Q16", "Account is no longer active"),
	RC_URL_EXPIRED(410, "T-Q17", "Link has been expired"),
	RC_URL_NOTFOUND(404, "T-Q18", "Link is not found"),
	RC_TYPEFILE_NOTALLOW(405, "T-Q19", "Type File not Allowed"),
	RC_MAX_FILE_SIZE(413, "T-Q20", "Maximum file upload"),
	RC_DATA_USED(400, "T-Q21", "Some data already being used"),
	RC_ACCESS_NOT_VALID(400, "T-Q22", "Current Access not valid"),
	
	RC_FAILURE(500, "T-VVV", "Web Service Failure"),	
	RC_FAIL_UPLOAD(503, "T-V01", "File upload failure");

	private int httpResponse;
	private String responseCode;
	private String responseMsg;
	
	private EResponseCode(int httpResponse, String responseCode, String responseMsg){
		this.httpResponse = httpResponse ;
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}	

	public int getHttpResponse() {
		return httpResponse;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	@Override
	public String toString() {
		return responseMsg;
	}
	
}
