package id.co.tripoin.core.dto.request;

import java.io.Serializable;

/**
 * created on 1/30/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestUpdateAddresDTO implements Serializable {
    private static final long serialVersionUID = -8365703058280762194L;

    private String name;
    private String remarks;
    private String detailAddress;
    private Integer provinceId;
    private Integer cityId;
    private Integer districtId;
    private Integer villageId;
    private Integer countryId;
    private String postalCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "RequestUpdateAddresDTO{" +
                "name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                ", villageId=" + villageId +
                ", countryId=" + countryId +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
