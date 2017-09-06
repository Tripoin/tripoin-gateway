package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.ASyncAuditrail;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = TableNameConstant.Security.SEC_COMPANY)
public class SecurityCompany extends ASyncAuditrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6328692326564037786L;

	@Override
	public String tableName() {
		return TableNameConstant.Security.SEC_COMPANY;
	}	

}
