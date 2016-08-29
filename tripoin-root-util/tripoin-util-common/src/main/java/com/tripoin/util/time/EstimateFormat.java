package com.tripoin.util.time;

import java.text.SimpleDateFormat;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class EstimateFormat {

	private static final String formatDefault = "dd MMMM yyyy HH:mm:ss";	
	public static SimpleDateFormat FORMAT_DEFAULT = new SimpleDateFormat(formatDefault);
	
	public static final String LAST_MODIFIED = "Last modified ";
	public static final String ON = "on ";
	public static final String DAYS = "a few days ago";
	public static final String DAY = "one day ago";
	public static final String HOURS = "a few hours ago";
	public static final String HOUR = "one hour ago";
	public static final String MINUTES = "a few minutes ago";
	public static final String MINUTE = "a minute ago";
	public static final String SECONDS = "a few seconds ago";
	public static final String SECOND = "a second ago";
	
}
