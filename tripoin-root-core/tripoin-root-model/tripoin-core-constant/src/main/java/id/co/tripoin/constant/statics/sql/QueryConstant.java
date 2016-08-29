package id.co.tripoin.constant.statics.sql;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class QueryConstant {

	public static final String SYS_PARAM_LOAD_VALUE = "SELECT * FROM sys_system_parameter WHERE system_parameter_code = ?";
	public static final String SYS_PARAM_LIST_VALUE = "SELECT * FROM sys_system_parameter WHERE system_parameter_code = ? OR system_parameter_code = ?";
	public static final String SYS_PARAM_ALL = "SELECT * FROM sys_system_parameter";

}
