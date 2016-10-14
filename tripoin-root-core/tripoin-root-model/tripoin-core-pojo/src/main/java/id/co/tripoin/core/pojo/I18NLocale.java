package id.co.tripoin.core.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name=TableNameConstant.Security.MST_LOCALE)
public class I18NLocale extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6939714779428715474L;	
	   
	@Override
	public String tableName() {
		return TableNameConstant.Security.MST_LOCALE;
	}

}
