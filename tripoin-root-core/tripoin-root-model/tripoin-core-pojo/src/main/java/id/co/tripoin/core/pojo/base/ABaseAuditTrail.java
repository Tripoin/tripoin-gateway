package id.co.tripoin.core.pojo.base;

import java.util.Date;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ABaseAuditTrail extends BaseMapperDATA<Long> implements IBasePojo {

	/**
	 *
	 */
	private static final long serialVersionUID = -4888747591156741211L;

	protected Integer status;
	protected String remarks;
	protected String createdBy;
	protected String createdIP;
	protected Date createdOn;
	protected String createdPlatform;
	protected String modifiedBy;
	protected String modifiedIP;
	protected Date modifiedOn;
	protected String modifiedPlatform;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdIP == null) ? 0 : createdIP.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ABaseAuditTrail other = (ABaseAuditTrail) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdIP == null) {
			if (other.createdIP != null)
				return false;
		} else if (!createdIP.equals(other.createdIP))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+" ABaseAuditTrail [status=" + status + ", remarks=" + remarks
				+ ", createdBy=" + createdBy + ", createdIP=" + createdIP
				+ ", createdTime=" + createdOn + ", createdPlatform="
				+ createdPlatform + ", modifiedBy=" + modifiedBy
				+ ", modifiedIP=" + modifiedIP + ", modifiedTime="
				+ modifiedOn + ", modifiedPlatform=" + modifiedPlatform + "]";
	}

}
