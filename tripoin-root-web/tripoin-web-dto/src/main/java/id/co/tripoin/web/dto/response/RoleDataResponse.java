package id.co.tripoin.web.dto.response;

import id.co.tripoin.web.dto.ResponseData;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class RoleDataResponse extends ResponseData implements Serializable {

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
