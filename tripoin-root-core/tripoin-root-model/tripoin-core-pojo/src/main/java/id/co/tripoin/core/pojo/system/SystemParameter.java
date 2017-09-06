package id.co.tripoin.core.pojo.system;

import java.sql.Date;
import java.sql.Timestamp;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.base.ABaseAuditTrail;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.System.SYS_PARAMETER)
public class SystemParameter extends AAuditTrail {

	/**
	 *
	 */
	private static final long serialVersionUID = -6784713469584117924L;

	@Override
	public String tableName() {
		return TableNameConstant.System.SYS_PARAMETER;
	}

	private SystemParameterGroup parameterGroup;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parameter_group_id")
	public SystemParameterGroup getParameterGroup() {
		return parameterGroup;
	}

	public void setParameterGroup(SystemParameterGroup parameterGroup) {
		this.parameterGroup = parameterGroup;
	}

	@Override
	public String toString() {
		return "SystemParameter [parameterGroup=" + parameterGroup.toString() + "]";
	}


}
