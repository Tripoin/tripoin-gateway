package id.co.tripoin.core.dto.response;

import java.util.Date;

public class AAuditTrailsResponseDTO extends BaseResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3435102121100251352L;

	private String createdBy;
	private String createdIP;
	private Date createdOn;
	private String createdPlatform;
	private String modifiedBy;
	private String modifiedIP;
	private Date modifiedOn;
	private String modifiedPlatform;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedIP() {
		return createdIP;
	}

	public void setCreatedIP(String createdIP) {
		this.createdIP = createdIP;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedPlatform() {
		return createdPlatform;
	}

	public void setCreatedPlatform(String createdPlatform) {
		this.createdPlatform = createdPlatform;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedIP() {
		return modifiedIP;
	}

	public void setModifiedIP(String modifiedIP) {
		this.modifiedIP = modifiedIP;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedPlatform() {
		return modifiedPlatform;
	}

	public void setModifiedPlatform(String modifiedPlatform) {
		this.modifiedPlatform = modifiedPlatform;
	}

	@Override
	public String toString() {
		return "AAuditTrailsResponseDTO{" +
				"createdBy='" + createdBy + '\'' +
				", createdIP='" + createdIP + '\'' +
				", createdOn=" + createdOn +
				", createdPlatform='" + createdPlatform + '\'' +
				", modifiedBy='" + modifiedBy + '\'' +
				", modifiedIP='" + modifiedIP + '\'' +
				", modifiedOn=" + modifiedOn +
				", modifiedPlatform='" + modifiedPlatform + '\'' +
				'}';
	}
}
