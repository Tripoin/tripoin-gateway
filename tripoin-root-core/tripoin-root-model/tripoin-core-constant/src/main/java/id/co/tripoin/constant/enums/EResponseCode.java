package id.co.tripoin.constant.enums;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EResponseCode {
	
	RC_SUCCESS("00", "Web Service Success"),
	RC_BAD_REQUEST("400", "Web Service Bad Request "),
	RC_FAILURE("500", "Web Service Failure "),
	
	RC_USERNAME_EXISTS("01", "Username already exists, please try others!"),
	RC_USERNAME_NOT_EXISTS("02", "Username not exsits"),
	RC_FAIL_PASSWORD("03", "Password not valid"),
	RC_EMAIL_EXISTS("04", "Email already exists, please try others!"),
	RC_EMAIL_NOT_EXISTS("05", "Email is not registered"),
	RC_PHONE_EXISTS("06", "Phone No. already exists, please try others!"),
	RC_PHONE_NOT_EXISTS("07", "Phone No. not exists!"),
	RC_GENDER_NOT_DEFINE("08", "Gender Not Define"),
	RC_ACCOUNT_EXPIRED("09", "Account is expired"),
	RC_ACCOUNT_NOTACTIVE("10", "Account is no longer active"),
	
	RC_URL_EXPIRED("201", "Link has been expired"),
	RC_URL_NOTFOUND("202", "Link is not found"),	
	RC_DATA_USED("203", "Some data already being used"),
	RC_TYPEFILE_NOTALLOW("204", "Type File not Allowed"),
	RC_MAX_FILE_SIZE("205", "Maximum file upload"),
	RC_FAIL_UPLOAD("206", "File upload failure ");

	private String operator;
	private String operand;
	
	private EResponseCode(String operator){
		this.operator = operator ;
	}	
	
	private EResponseCode(String operator, String operand){
		this.operator = operator ;
		this.operand = operand;
	}
	
	public String getResponseCode() {
		return operator;
	}

	@Override
	public String toString() {
		return operand;
	}
	
}
