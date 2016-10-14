package id.co.tripoin.core.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestFindByCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6507138897168967517L;
	private String code;	
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "RequestByCode [code=" + code + "]";
	}	
	
}
