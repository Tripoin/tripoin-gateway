package id.co.tripoin.core.pojo.master.city;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.master.district.District;
import id.co.tripoin.core.pojo.master.province.Province;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Master.MST_CITY)
public class City extends AAuditTrail {
	
	/**
	 * 
	 * 
	 */
    private static final long serialVersionUID = -5329991434389083265L;

    @Override
    public String tableName() {
        return TableNameConstant.Master.MST_CITY;
    }

    private Province province;
    private Set<District> districts;
    
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    public Set<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "province=" + province +
                '}';
    }
}
