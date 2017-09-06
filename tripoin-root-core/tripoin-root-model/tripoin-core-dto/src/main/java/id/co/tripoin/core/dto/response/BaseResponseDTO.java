package id.co.tripoin.core.dto.response;

import java.io.Serializable;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BaseResponseDTO extends MasterResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1995342918546200653L;

	private Long id;
	private String remarks;
	private Integer status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BaseResponseDTO{" +
				"id=" + id +
				", remarks='" + remarks + '\'' +
				", status=" + status +
				'}';
	}
}
