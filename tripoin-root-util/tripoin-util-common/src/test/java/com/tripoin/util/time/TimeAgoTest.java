package com.tripoin.util.time;

import id.co.tripoin.util.time.TimeAgo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TimeAgoTest {
	
	private static transient final Logger LOGGER = LoggerFactory.getLogger(TimeAgoTest.class);
	
	@Test
	public void runTest(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		try {				
			Date date1 = simpleDateFormat.parse("29/10/2015 11:30:10");
			Date date2 = new Date();
				
			LOGGER.info(TimeAgo.estimatedTime(date1, date2));
				
		}catch (ParseException e) {
			LOGGER.error("Error Parser",e);
		}
	}

}
