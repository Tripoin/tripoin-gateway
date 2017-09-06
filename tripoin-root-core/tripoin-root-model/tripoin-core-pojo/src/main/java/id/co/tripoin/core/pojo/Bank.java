package id.co.tripoin.core.pojo;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * created on 10/16/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Master.MST_BANK)
public class Bank extends AAuditTrail{
    private static final long serialVersionUID = -1438686728501786982L;

    @Override
    public String tableName() {
        return TableNameConstant.Master.MST_BANK;
    }
}
