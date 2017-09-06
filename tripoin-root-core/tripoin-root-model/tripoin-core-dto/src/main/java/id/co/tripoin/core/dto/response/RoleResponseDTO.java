package id.co.tripoin.core.dto.response;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class RoleResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -426740708719971251L;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
