package id.co.tripoin.core.pojo.base;

import java.sql.Timestamp;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ABaseAuditTrail implements IBasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888747591156741211L;
	protected Integer status;
	protected String remarks;
	protected String createdBy;
	protected String createdIP;
	protected Timestamp createdTime;
	protected String createdPlatform;
	protected String modifiedBy;
	protected String modifiedIP;
	protected Timestamp modifiedTime;
	protected String modifiedPlatform;
	
	@Override
	public String toString() {
		return "ABaseAuditTrail [status=" + status + ", remarks=" + remarks
				+ ", createdBy=" + createdBy + ", createdIP=" + createdIP
				+ ", createdTime=" + createdTime + ", createdPlatform="
				+ createdPlatform + ", modifiedBy=" + modifiedBy
				+ ", modifiedIP=" + modifiedIP + ", modifiedTime="
				+ modifiedTime + ", modifiedPlatform=" + modifiedPlatform + "]";
	}

}
