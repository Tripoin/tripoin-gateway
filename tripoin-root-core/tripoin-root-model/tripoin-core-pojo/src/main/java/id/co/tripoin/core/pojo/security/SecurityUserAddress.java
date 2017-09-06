package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.master.city.City;
import id.co.tripoin.core.pojo.master.country.Country;
import id.co.tripoin.core.pojo.master.district.District;
import id.co.tripoin.core.pojo.master.province.Province;
import id.co.tripoin.core.pojo.master.village.Village;

import javax.persistence.*;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Security.SEC_USER_ADDRESS)
public class SecurityUserAddress extends AAuditTrail {
    private static final long serialVersionUID = 3638338511792841794L;

    @Override
    public String tableName() {
        return TableNameConstant.Security.SEC_USER_ADDRESS;
    }

    private String detailAddress;
    private String postalCode;
    private Country country;
    private Province province;
    private City city;
    private District district;
    private Village village;

    @ManyToOne
    @JoinColumn(name = "village_id")
    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @ManyToOne
    @JoinColumn(name = "province_id")
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "district_id")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Column(name = "detail_address")
    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "SecurityUserAddress{" +
                "detailAddress='" + detailAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                ", province=" + province +
                ", city=" + city +
                ", district=" + district +
                ", village=" + village +
                '}';
    }
}
