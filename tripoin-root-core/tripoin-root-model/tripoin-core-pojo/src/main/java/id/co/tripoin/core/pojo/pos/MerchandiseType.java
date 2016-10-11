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

	private Long id;
	private String code;
	private String name;
	
	@Override
	public String tableName() {	
		return TableNameConstant.Master.MST_MERCHANDISE_TYPE;
	}

	@Size(max = 50)
	@Column(name = "merchandise_type_code", length = 50, unique = true)	
	@Override
	public String getCode() {			
		return code;
	}

	@Size(max = 50)
	@Column(name = "merchandise_type_name", length = 50)
	@Override
	public String getName() {
		return name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="merchandise_type_id")
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
