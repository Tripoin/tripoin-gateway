package id.co.tripoin.web.dto.request;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class AuthenticationDataRequest {

	private String oldAccess;
	private String newAccess;

	public String getOldAccess() {
		return oldAccess;
	}

	public void setOldAccess(String oldAccess) {
		this.oldAccess = oldAccess;
	}

	public String getNewAccess() {
		return newAccess;
	}

	public void setNewAccess(String newAccess) {
		this.newAccess = newAccess;
	}

}
