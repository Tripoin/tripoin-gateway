package id.co.tripoin.core.integration.provider;

import id.co.tripoin.core.dto.TripoinAuthenticationDetailDTO;
import id.co.tripoin.core.pojo.base.TripoinAuthenticationDetail;
import org.springframework.security.core.context.SecurityContextHolder;


public class TripoinAuthenticationProvider {

	private String userName;
	private String ipAddress;
	private String platform;

	public TripoinAuthenticationDetailDTO generateAuth(){
		TripoinAuthenticationDetail tripoinAuthenticationDetail = (TripoinAuthenticationDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
		TripoinAuthenticationDetailDTO tripoinAuthenticationDetailDTO = tripoinAuthenticationDetail.getTripoinAuthenticationDetailDTO();
		userName = tripoinAuthenticationDetail.getTripoinAuthenticationDetailDTO().getUserName();
		ipAddress = tripoinAuthenticationDetail.getTripoinAuthenticationDetailDTO().getIpAddress();
		platform = tripoinAuthenticationDetail.getTripoinAuthenticationDetailDTO().getPlatform();
		return tripoinAuthenticationDetailDTO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
