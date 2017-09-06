package id.co.tripoin.core.pojo.master.district;


import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.master.city.City;
import id.co.tripoin.core.pojo.master.village.Village;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Master.MST_DISTRICT)
public class District extends AAuditTrail {

    /**
     *
     *
     */
    private static final long serialVersionUID = -6165282598525095185L;

    private Set<Village> villages;

    private City city;

    @OneToMany(mappedBy = "district", fetch = FetchType.EAGER)
    public Set<Village> getVillages() {
        return villages;
    }

    public void setVillages(Set<Village> villages) {
        this.villages = villages;
    }

    @Override
    public String tableName() {
        return TableNameConstant.Master.MST_DISTRICT;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
