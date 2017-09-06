package id.co.tripoin.core.constant.statics;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface TableNameConstant {

	interface Security{
		String SEC_USER_DETAILS = "sec_user_details";
		String SEC_USER_PROFILE = "sec_user_profile";
		String SEC_ROLE = "sec_role";
		String SEC_LOCALE = "sec_locale";
		String SEC_GROUP = "sec_group";
		String SEC_BRANCH = "sec_branch";
		String SEC_COMPANY = "sec_company";
		String SEC_FUNCTION = "sec_function";
		String SEC_FUNCTION_ASSIGNMENT = "sec_function_assignment";
		String SEC_USER_ADDRESS = "sec_user_address";
		String SEC_USER_CONTACT = "sec_contact";
		String SEC_OAUTH_CLIENT_DETAILS = "sec_oauth_client_details";
		String SEC_USER_VERIFICATION = "sec_user_verification";
	}

	interface System{
		String SYS_PARAMETER = "sys_parameter";
		String SYS_PARAMETER_GROUP = "sys_parameter_group";
	}

	
	interface Master{
		String MST_COMPANY = "mst_company";
		String MST_BRANCH = "mst_branch";
		String MST_API_TYPE = "mst_api_type";
		String MST_PRODUCT_TYPE = "mst_product_type";
		String MST_PRODUCT_BRAND = "mst_product_brand";
		String MST_BANK = "mst_bank";
		String MST_COUNTRY = "mst_country";
		String MST_PROVINCE = "mst_province";
		String MST_CITY = "mst_city";
		String MST_DISTRICT = "mst_district";
		String MST_VILLAGE = "mst_village";
	}
}
