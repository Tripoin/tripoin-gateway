package id.co.tripoin.core.dto.request;

import java.io.Serializable;

/**
 * created on 11/2/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestMemberActivationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3625783656199546156L;
	
	private String email;
	private String token;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "RequestMemberActivationDTO [email=" + email + ", token=" + token + "]";
	}
	
	
}
