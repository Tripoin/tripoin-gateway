package id.co.tripoin.core.dto.request;

import java.io.Serializable;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestResetPasswordDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710247954189366141L;
	
	private String token;
	private String newPassword;
	private String retypeNewPassword;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
		return "RequestResetPasswordDTO [token=" + token + ", newPassword=" + newPassword + ", retypeNewPassword="
				+ retypeNewPassword + "]";
	}
	
	

}
