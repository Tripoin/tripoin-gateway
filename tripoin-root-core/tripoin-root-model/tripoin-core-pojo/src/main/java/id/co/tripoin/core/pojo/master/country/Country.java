package id.co.tripoin.core.pojo.master.country;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.ASyncAuditrail;
import id.co.tripoin.core.pojo.master.province.Province;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Master.MST_COUNTRY)
public class Country extends ASyncAuditrail {
    private static final long serialVersionUID = -3871254896944959025L;

    private Set<Province> province;
    
    @Override
    public String tableName() {
        return TableNameConstant.Master.MST_COUNTRY;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
	public Set<Province> getProvince() {
		return province;
	}

	public void setProvince(Set<Province> province) {
		this.province = province;
	}
        
}
