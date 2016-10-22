package id.co.tripoin.web.dto.response;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class AuthTokenDataResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4297338884930856131L;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
