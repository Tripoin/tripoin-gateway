package id.co.tripoin.core.pojo.master.province;


import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.master.city.City;
import id.co.tripoin.core.pojo.master.country.Country;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Master.MST_PROVINCE)
public class Province extends AAuditTrail {
    private static final long serialVersionUID = 4877117558375920984L;

    private Country country;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
    public String tableName() {
        return TableNameConstant.Master.MST_PROVINCE;
    }

    private Set<City> cities;

    @OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
    
    
}
