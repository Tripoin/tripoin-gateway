package id.co.tripoin.util.time;

import java.text.SimpleDateFormat;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class FormatDateConstant {

	private static final String patternDefault = "dd-MM-yyyy HH:mm:ss.S";
	private static final String patternISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";	
	private static final String patternDateOfBirth = "yyyy-MM-dd";
	
	public static SimpleDateFormat DEFAULT = new SimpleDateFormat(patternDefault);
	public static SimpleDateFormat ISO8601 = new SimpleDateFormat(patternISO8601);
	public static SimpleDateFormat DATE_OF_BIRTH = new SimpleDateFormat(patternDateOfBirth);
	
}
