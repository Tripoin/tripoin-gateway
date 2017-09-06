package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.ASyncAuditrail;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name= TableNameConstant.Security.SEC_LOCALE)
public class I18NLocale extends ASyncAuditrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6939714779428715474L;	
	   
	@Override
	public String tableName() {
		return TableNameConstant.Security.SEC_LOCALE;
	}

}
