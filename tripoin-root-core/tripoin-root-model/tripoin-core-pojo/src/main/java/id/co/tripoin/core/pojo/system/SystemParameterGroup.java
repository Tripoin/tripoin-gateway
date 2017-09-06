package id.co.tripoin.core.pojo.system;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = TableNameConstant.System.SYS_PARAMETER_GROUP)
public class SystemParameterGroup extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5715517653490981393L;

	private Set<SystemParameter> systemParameters;
	
	@Override
	public String tableName() {
		return TableNameConstant.System.SYS_PARAMETER_GROUP;
	}

	@OneToMany(mappedBy = "parameterGroup", fetch = FetchType.EAGER)
	public Set<SystemParameter> getSystemParameters() {
		return systemParameters;
	}

	public void setSystemParameters(Set<SystemParameter> systemParameters) {
		this.systemParameters = systemParameters;
	}

	@Override
	public String toString() {
		return "SystemParameterGroup [status=" + status + ", remarks=" + remarks + ", createdBy=" + createdBy
				+ ", createdIP=" + createdIP + ", createdOn=" + createdOn + ", createdPlatform=" + createdPlatform
				+ ", modifiedBy=" + modifiedBy + ", modifiedIP=" + modifiedIP + ", modifiedOn=" + modifiedOn
				+ ", modifiedPlatform=" + modifiedPlatform + "]";
	}
	
	

}
