package id.co.tripoin.core.pojo.pos;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */

@Entity
@Table(name = TableNameConstant.Master.MST_PRODUCT_TYPE)
public class ProductType extends AAuditTrail{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4170557373413141124L;

	@Override
	public String tableName() {
		return TableNameConstant.Master.MST_PRODUCT_TYPE;
	}
}
