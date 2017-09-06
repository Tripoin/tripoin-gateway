package id.co.tripoin.core.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestFindByName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2523385016839756736L;

	private String name;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "RequestByName [name=" + name + "]";
	}	
}
