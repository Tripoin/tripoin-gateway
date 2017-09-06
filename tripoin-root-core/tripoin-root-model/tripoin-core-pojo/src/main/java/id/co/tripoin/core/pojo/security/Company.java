package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = TableNameConstant.Master.MST_COMPANY)
public class Company extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752398398784954658L;

	@Override
	public String tableName() {
		return TableNameConstant.Master.MST_COMPANY;
	}

}
