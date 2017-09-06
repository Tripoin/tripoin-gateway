package id.co.tripoin.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestFindById implements Serializable{

	private static final long serialVersionUID = -4151102909500781274L;
	private Long id;
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RequestFindById{" +
				"id=" + id +
				'}';
	}
}
