package id.co.tripoin.core.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
@XmlRootElement
public class MasterResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -889033211964744624L;
	private String code;
	private String name;
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MasterDataResponse{" +
				"code='" + code + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
