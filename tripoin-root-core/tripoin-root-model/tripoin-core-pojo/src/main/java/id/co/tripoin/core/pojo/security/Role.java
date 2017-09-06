package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name= TableNameConstant.Security.SEC_ROLE)
public class Role extends AAuditTrail implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5208531126588851646L;
	
	public Role() {}
	
	public Role(String authority) {
		setCode(authority);
	}
	
	@Override
	public String getAuthority() {
		return getCode();
	}

	public void setAuthority(String authority) {
		setCode(authority);
	}

	@Override
	public String tableName() {
		return TableNameConstant.Security.SEC_ROLE;
	}
	
}
