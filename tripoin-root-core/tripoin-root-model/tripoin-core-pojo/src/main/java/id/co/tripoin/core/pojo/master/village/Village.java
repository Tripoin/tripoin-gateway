package id.co.tripoin.core.pojo.master.village;


import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.master.district.District;

import javax.persistence.*;

/**
 * created on 1/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Master.MST_VILLAGE)
public class Village extends AAuditTrail {
    private static final long serialVersionUID = -882333480264178395L;

    @Override
    public String tableName() {
        return TableNameConstant.Master.MST_VILLAGE;
    }

    private District district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Village{" +
                "district=" + district +
                '}';
    }
}
