package id.co.tripoin.core.constant.statics;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface BeanNameConstant {


	String SYSTEM_PARAMETER_SERVICE_BEAN = "systemParameterService";
	String SYSTEM_PARAMETER_DAO_BEAN = "systemParameterDao";
	String AUTHENTICATION_SERVICE_BEAN = "authenticationService";
	String AUTHENTICATION_DAO_BEAN = "authenticationDao";
	String AUTHENTICATION_ENDPOINT_BEAN = "authenticationEndpoint";
	String CONNECTION_ENDPOINT_BEAN = "connectionEndpoint";
	String I18NLOCALE_SERVICE_BEAN = "i18NLocaleService";
	String I18NLOCALE_PROFILE_ENDPOINT_BEAN = "i18NLocaleProfileEndpoint";
	String PROFILE_SERVICE_BEAN = "profileService";
	String API_TYPE_SERVICE_BEAN = "apiTypeService";
	String API_TYPE_ENDPOINT_BEAN = "apiTypeEndpointBean";

	String SCAFFOLDING_SERVICE_BEAN = "scaffoldingService";

	interface Security{
		String SECURITY_COMPANY_BEAN = "securityCompanyBean";
		String SECURITY_BRANCH_BEAN = "securityBranchBean";
		String SECURITY_GROUP_BEAN = "securityGroupBean";
		String SECURITY_ROLE_BEAN = "securityRoleBean";
		String SECURITY_LOCALE_BEAN = "securityLocaleBean";
		String SECURITY_FUNCTION_BEAN = "securityFunctionBean";
		String SECURITY_FUNCTION_ASSIGNMENT_BEAN = "securityFunctionAssignmentBean";
		String MENU_ADMIN_GENERATOR_BEAN = "menuAdminGeneratorBean";
		String SECURITY_USER_PROFILE_ENDPOINT_BEAN = "securityUserProfileEndPointBean";
		String SECURITY_FORGOT_PASSWORD_ENDPOINT_BEAN = "securityForgotPasswordEndPointBean";
	}
	
}
