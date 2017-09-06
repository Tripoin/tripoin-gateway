package id.co.tripoin.core.dto.request;

import java.io.Serializable;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestForgotPasswordDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3921324051078092998L;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
