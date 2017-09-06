package id.co.tripoin.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestAdvancedPaginationDTO extends PaginationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5358819343016294073L;

	@JsonProperty("filterKey")
	private String filterKey;
	
	@JsonProperty("filterValue")
	private String filterValue;
	
	public String getFilterKey() {
		return filterKey;
	}
	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	@Override
	public String toString() {
		return "RequestAdvancedPaginationDTO [filterKey=" + filterKey + ", filterValue=" + filterValue + "]";
	}
	
	
}
