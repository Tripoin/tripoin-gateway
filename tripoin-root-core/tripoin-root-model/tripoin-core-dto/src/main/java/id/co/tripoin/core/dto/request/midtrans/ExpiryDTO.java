package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;
import java.util.Date;

public class ExpiryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3791624704873988L;
	private String start_time;
	private String unit;
	private int duration;
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
