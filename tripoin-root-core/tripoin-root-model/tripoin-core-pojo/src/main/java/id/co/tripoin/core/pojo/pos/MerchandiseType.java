package id.co.tripoin.core.pojo.pos;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */

@Entity
@Table(name = TableNameConstant.Master.MST_MERCHANDISE_TYPE)
public class MerchandiseType extends AAuditTrail{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4170557373413141124L;

	@Override
	public String tableName() {
		return TableNameConstant.Master.MST_MERCHANDISE_TYPE;
	}
}
