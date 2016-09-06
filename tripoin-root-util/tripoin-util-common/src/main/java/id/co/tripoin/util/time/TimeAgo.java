package id.co.tripoin.util.time;

import java.util.Date;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class TimeAgo {

	public static final String estimatedTime(Date startDate, Date endDate){
		long different = endDate.getTime() - startDate.getTime();		
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		
		long elapsedSeconds = different / secondsInMilli;
		
		if(elapsedDays > 7)
			return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.ON).concat(EstimateFormat.FORMAT_DEFAULT.format(startDate));
		else if(elapsedDays > 0 && elapsedDays <= 7){
			if(elapsedDays == 1)
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.DAY);
			else
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.DAYS);				
		}else if(elapsedHours > 0){
			if(elapsedHours == 1)
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.HOUR);
			else
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.HOURS);				
		}else if(elapsedMinutes > 0){
			if(elapsedMinutes == 1)
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.MINUTE);
			else
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.MINUTES);				
		}else{
			if(elapsedSeconds <= 2)
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.SECOND);
			else
				return EstimateFormat.LAST_MODIFIED.concat(EstimateFormat.SECONDS);				
		}
	}
	
}
