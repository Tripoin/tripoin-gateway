package id.co.tripoin.core.dto.request;

import java.io.Serializable;

public class RequestUpdatePasswordDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7107431870618361990L;

	private String userName;
	private String oldPassword;
	private String newPassword;
	private String retypeNewPassword;
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRetypeNewPassword() {
		return retypeNewPassword;
	}
	public void setRetypeNewPassword(String retypeNewPassword) {
		this.retypeNewPassword = retypeNewPassword;
	}
	
	@Override
	public String toString() {
		return "RequestUpdatePasswordDTO [userId=" + userName + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", retypeNewPassword=" + retypeNewPassword + "]";
	}
	

}
