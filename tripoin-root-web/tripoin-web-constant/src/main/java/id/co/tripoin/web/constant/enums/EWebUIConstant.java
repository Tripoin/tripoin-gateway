package id.co.tripoin.web.constant.enums;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EWebUIConstant {

	
	LOGIN_FAILED_TITLE("Login Failed"),
	LOGIN_FAILED_DESC("Please check username and password and try again."),
	LOGIN_USERNAME_NULL_DESC("Username empty."),
	LOGIN_PASSWORD_NULL_DESC("Password empty."),

    NOTIF_CAPTCHA_FAILURE_TITLE("Captcha Failure"),		
    NOTIF_CAPTCHA_NOTVALID_DESC("Captcha is not valid."),
	NOTIF_SUCCESS_FORGOT_PASSWORD_TITLE("Email Confirmation"),
	NOTIF_SUCCESS_FORGOT_PASSWORD_DESC("Confirmation change password has been sent, please check your email!\n"
        		+ "Keep me logged in."),
    NOTIF_FAILURE_FORGOT_PASSWORD_TITLE("Warning"),
    NOTIF_EMAIL_FAILURE_FORGOT_PASSWORD_TITLE("Email Failure"),
    NOTIF_EMAIL_FAILURE_FORGOT_PASSWORD_DESC("Email and Re-Type Email must be same."),
    NOTIF_EMAIL_FAILURE_VERIFY_FORGOT_PASSWORD_TITLE("Link Failure"),
    NOTIF_ACCOUNT_EXPIRED_FORGOT_PASSWORD_DESC("Account has been expired."),
    NOTIF_ACOUNT_ENABLED_FORGOT_PASSWORD_DESC("Account is no longer active."),	
    NOTIF_EMAIL_NULL_FORGOT_PASSWORD_DESC("Email is not registered."),		
    NOTIF_EMAIL_NOTVALID_FORGOT_PASSWORD_DESC("Email is not valid."),
    NOTIF_LINK_EXPIRED_FORGOT_PASSWORD_DESC("Link has been is expired."),
    NOTIF_LINK_NULL_FORGOT_PASSWORD_DESC("Link is not found."),

    REGEX_EMAIL("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
	REGEX_USERNAME("^[a-zA-Z0-9_.@-]{5,55}$"),
	REGEX_PHONE_NUMBER("^[0-9\\-\\+]+[0-9]{9,15}$"),
	REGEX_ACCOUNT_NUMBER("^[0-9]{7,15}$"),
	REGEX_PASSWORD("((?=\\S+$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{6,20})"),
	REGEX_CONTAINS_LOWERUPERCASE("((?=\\S+$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})"),
	REGEX_CONTAINS_DIGIT("((?=\\S+$)(?=.*\\d).{6,20})"),
	REGEX_CONTAINS_WHITESPACE("((?=\\S+$).{6,20})"),
	REGEX_CONTAINS_MINMAX(".{6,20}"),
	REGEX_AUTHORIZATION("Basic |\\[|\\]"),
	
	JSESSIONID("JSESSIONID"),
	COOKIE("Cookie"),
	/**
	 * take the number in front of and replace any existing character behind
	 * example : 3214h3kjagd-089741
	 * result  : 3214
	 */
	REGEX_FRONT_CONTAINS_DIGIT("[^\\d+].*"),
	
	AUTHORIZATION("Authorization"),
    
    EXCEPTION("Exception"),

    IDENTIFIER_TIME("IDENTIFIER_TIME"),
    IDENTIFIER_IP("IDENTIFIER_IP"),
    IDENTIFIER_PLATFORM("IDENTIFIER_PLATFORM"),
	
	HOME_VIEW(""),
	NAVIGATE_NULL("#!"),

	NAVIGATE_AFTER_FORM("NAVIGATE-AFTER-FORM"),
	NAVIGATE_AFTER_SUBMIT("NAVIGATE-AFTER-SUBMIT"),
	
	TYPE_FILE_IMAGE("image"),
	
	BUTTON_PAGING(5),	
	ROW_PER_PAGE(10),
	
	MAX_SIZE_IMAGE_BYTE(1000000);

	private String operator;
	private Integer operatorInteger;
	private String operand;
	
	private EWebUIConstant(String operator){
		this.operator = operator ;
	}	
	
	private EWebUIConstant(String operator, String operand){
		this.operator = operator ;
		this.operand = operand;
	}	
	
	private EWebUIConstant(Integer operatorInteger){
		this.operatorInteger = operatorInteger ;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public String getOperand(){
		return operand;
	}

	public Integer getOperatorInt() {
		return operatorInteger;
	}

	@Override
	public String toString() {
		if(operator == null)
			return operatorInteger.toString();
		return operator;
	}
	
}
