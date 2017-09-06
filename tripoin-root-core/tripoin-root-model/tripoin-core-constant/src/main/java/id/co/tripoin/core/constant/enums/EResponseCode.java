package id.co.tripoin.core.constant.enums;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EResponseCode {

	RC_SUCCESS(200, "X-000", "Web Service Success"),
	RC_LOGOUT_SUCCESS(200, "X-001", "Logout Success"),
	RC_REGISTRATION_MEMBER_SUCCESS(200, "X-002", "Registration Member Success"),
	RC_MEMBER_ACTIVATION_SUCCESS(200, "X-003", "Member Activation Success"),
	RC_FIND_TOURISM_TYPE_AND_DATE_SUCCESS(200, "X-004", "Filter Tourism By Type and Date Success"),
	RC_FIND_TOURISM_DETAIL_BY_NAME_SUCCESS(200, "X-005", "Filter Tourism Detail By Name Success"),
	RC_FIND_TOURISM_CLAZZ_SEAT_SUCCESS(200, "X-006", "Filter Tourism Clazz and Seat Success"),
	RC_PICK_SEAT_SUCCESS(200, "X-007", "Pick Seat Success"),
	RC_GET_PROFILE_SUCCESS(200, "X-008", "Get Profile Success"),
	RC_UPDATE_PROFILE_SUCCESS(200, "X-009", "Update Profile Success"),
	RC_UPDATE_PASSWORD_SUCCESS(200, "X-010", "Update Password Success"),
	RC_REQUEST_FORGOT_PASSWORD_SUCCESS(200, "X-011", "Request Forgot Password Success"),
	RC_RESET_PASSWORD_SUCCESS(200, "X-012", "Reset Password Success"),
	RC_PROMO_NOTIFICATION_SUCCESS(200, "X-V13", "Request Notification Success"),
	RC_EVENT_RESERVATION_SUCCESS(200, "X-V14", "Make Event Reservation Success"),
	RC_TOURISM_RESERVATION_SUCCESS(200, "X-V15", "Make Tourism Reservation Success"),
	RC_PAYMENT_INTERNAL_SUCCESS(200, "X-V16", "Make Internal Payment Success"),
	RC_INSERT_FARE_WITH_TOURISM_SUCCESS(200, "X-V17", "Insert Fare With Tourism Success"),
	RC_UPDATE_FARE_WITH_TOURISM_SUCCESS(200, "X-V18", "Update Fare With Tourism Success"),
	RC_FIND_RESERVATION_SUCCESS(200, "X-V19", "Find Reservation Succes"),
	RC_PAYMENT_CONFIRMATION_SUCCESS(200, "X-V20", "Payment Confirmation Succes"),
	RC_TOURISM_MIN_MAX_SUCCESS(200, "X-Q21", "Find Tourism with MIN and MAX Success"),
	RC_FIND_NUMBER_OF_SEAT_SUCCESS(200, "X-Q22", "Find Number Of Seat Success"),

	RC_BAD_REQUEST(400, "X-QQQ", "Web Service Bad Request"),
	RC_BAD_CREDENTIALS(401, "X-Q01", "Web Service Bad Credentials"),
	RC_INVALID_TOKEN(401, "X-Q02", "Web Service Invalid Access Token"),
	RC_UNAUTHORIZED(401, "X-Q03", "Web Service Unauthorized"),
	RC_ACCESS_DENIED(403, "X-Q04", "Web Service Access is denied"),
	RC_BAD_TRIPOIN_KEY(400, "T-Q05", "Invalid X-Tripoin-Key"),
	RC_BAD_TRIPOIN_TIMESTAMP(400, "T-Q06", "Invalid X-Tripoin-Timestamp (ISO8601)"),
	RC_BAD_TRIPOIN_SIGNATURE(400, "T-Q07", "Invalid X-Tripoin-Signature"),
	RC_USERNAME_EXISTS(409, "X-Q08", "Username already exists, please try others!"),
	RC_USERNAME_NOT_EXISTS(404, "X-Q09", "Username not exists"),
	RC_FAIL_PASSWORD(400, "X-Q10", "Invalid Password"),
	RC_EMAIL_EXISTS(409, "X-Q11", "Email already exists, please try others!"),
	RC_EMAIL_NOT_EXISTS(404, "X-Q12", "Email is not registered"),
	RC_PHONE_EXISTS(409, "X-Q13", "Phone No. already exists, please try others!"),
	RC_PHONE_NOT_EXISTS(404, "X-Q14", "Phone No. not exists!"),
	RC_GENDER_NOT_DEFINE(404, "X-Q15", "Gender Not Define"),
	RC_ACCOUNT_EXPIRED(410, "X-Q16", "Account is expired"),
	RC_ACCOUNT_NOTACTIVE(410, "X-Q17", "Account is no longer active"),
	RC_URL_EXPIRED(410, "X-Q18", "Link has been expired"),
	RC_URL_NOTFOUND(404, "X-Q19", "Link is not found"),
	RC_TYPEFILE_NOTALLOW(405, "X-Q20", "Type File not Allowed"),
	RC_MAX_FILE_SIZE(413, "X-Q21", "Maximum file upload"),
	RC_DATA_USED(400, "X-Q22", "Some data already being used"),
	RC_ACCESS_NOT_VALID(400, "X-Q23", "Current Access not valid"),
	RC_LOCALE_NOT_NULL(400, "X-Q24", "Locale Code not null"),
	RC_LOCALE_NOT_FOUND(400, "X-Q25", "Locale not found"),
	RC_GROUP_NOT_FOUND(400, "X-Q26", "Group not found"),
	RC_MANDATORY_NOT_COMPLETED(400, "X-Q27", "Mandatory is not completed"),
	RC_EMAIL_NOT_VALID(410, "X-Q28", "Email is not valid! || Already Registered"),
	RC_USER_NOT_EXISTS(410, "X-Q29", "User not exists"),
	RC_TOKEN_EXPIRED(410, "X-Q30", "Token is Expired"),
	RC_PASSWORD_NOT_MATCH(410, "X-Q31", "Password Does Not Match"),
	RC_BAD_DATE_FORMAT(410, "X-Q32", "Bad Date Format, should be dd-MM-yyyy"),
	RC_OLD_PASSWORD_FALSE(410, "X-Q33", "Old Password is Not Correct"),
	RC_NEW_PASSWORD_NOT_EQUAL_RETYPE(410, "X-Q34", "New Password Did Not Equal Retype New Password"),
	RC_DATA_IS_EMPTY(410, "X-Q35", "Data is Empty"),
	RC_DATA_NOT_FOUND(410, "X-Q36", "Data Not Found"),

	RC_FAILURE(500, "X-VVV", "Web Service Failure"),
	RC_FAIL_UPLOAD(503, "X-V01", "File upload failure"),
	RC_REGISTRATION_MEMBER_FAILED(400, "X-V02", "Registration Member Failed"),
	RC_FIND_TOURISM_TYPE_AND_DATE_FAILED(400, "X-V03", "Filter Tourism By Type and Date Failed"),
	RC_FIND_TOURISM_DETAIL_BY_NAME_FAILED(400, "X-V04", "Filter Tourism By Detail By Name Failed"),
	RC_FIND_TOURISM_CLAZZ_SEAT_FAILED(400, "X-V05", "Filter Tourism Clazz and Seat Failed"),
	RC_FIND_TOURISM_CLAZZ_IS_EMPTY(400, "X-V06", "Filter Tourism Clazz is Empty"),
	RC_FIND_TOURISM_SEAT_IS_EMPTY(400, "X-V07", "Filter Tourism Seat is Empty"),
	RC_PICK_SEAT_FAILED(400, "X-V08", "Pick Seat Failed"),
	RC_GET_PROFILE_FAILED(500, "X-V09", "Get Profile Failed"),
	RC_UPDATE_PROFILE_FAILED(500, "X-V10", "Update Profile Failed"),
	RC_UPDATE_PASSWORD_FAILED(500, "X-V11", "Update Password Failed"),
	RC_REQUEST_FORGOT_PASSWORD_FAILED(500, "X-V12", "Request Forgot Password Failed"),
	RC_RESET_PASSWORD_FAILED(500, "X-V13", "Reset Password Failed"),
	RC_PROMO_NOTIFICATION_FAILED(500, "X-V14", "Request Notification Failed"),
	RC_PROMO_NOT_AVAILABLE(500, "X-V15", "Promo is not Available"),
	RC_CURRENT_DATE_GREATER_THAN_VISIT_DATE(500, "X-V16", "Visit Date must be Greater than Current Date"),
	RC_EVENT_RESERVATION_FAILED(500, "X-V17", "Make Event Reservation Failed"),
	RC_TOURISM_RESERVATION_FAILED(500, "X-V17", "Make Tourism Reservation Failed"),
	RC_PAYMENT_INTERNAL_FAILED(500, "X-V18", "Make Internal Payment Failed"),
	RC_INSERT_FARE_WITH_TOURISM_FAILED(500, "X-V19", "Insert Fare With Tourism Failed"),
	RC_UPDATE_FARE_WITH_TOURISM_FAILED(500, "X-V20", "Update Fare With Tourism Failed"),
	RC_FIND_RESERVATION_FAILED(500, "X-V21", "Find Reservation Failed"),
	RC_FIND_RESERVATION_NOT_FOUND(500, "X-Q22", "Reservation Not Found"),
	RC_PAYMENT_CONFIRMATION_FAILED(500, "X-Q23", "Payment Confirmation Failed"),
	RC_TOURISM_MIN_MAX_FAILED(500, "X-Q24", "Find Tourism with MIN and MAX Failed"),
	RC_FIND_NUMBER_OF_SEAT_FAILED(500, "X-Q25", "Find Number Of Seat Failed");


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
