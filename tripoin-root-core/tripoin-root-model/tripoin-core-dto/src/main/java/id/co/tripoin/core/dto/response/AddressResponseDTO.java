package id.co.tripoin.core.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * created on 1/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AddressResponseDTO implements Serializable {
    private static final long serialVersionUID = -6115011652299047573L;

    @JsonProperty(value = "detail_address")
    private String detailAddress;

    @JsonProperty(value = "postal_code")
    private String postalCode;

    @JsonProperty(value = "country")
    private CountryResponseDTO country;

    @JsonProperty(value = "province")
    private ProvinceResponseDTO province;

    @JsonProperty(value = "city")
    private CityResponseDTO city;

    @JsonProperty(value = "district")
    private DistrictResponseDTO district;

    @JsonProperty(value = "village")
    private VillageResponseDTO village;

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CountryResponseDTO getCountry() {
        return country;
    }

    public void setCountry(CountryResponseDTO country) {
        this.country = country;
    }

    public ProvinceResponseDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceResponseDTO province) {
        this.province = province;
    }

    public CityResponseDTO getCity() {
        return city;
    }

    public void setCity(CityResponseDTO city) {
        this.city = city;
    }

    public DistrictResponseDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictResponseDTO district) {
        this.district = district;
    }

    public VillageResponseDTO getVillage() {
        return village;
    }

    public void setVillage(VillageResponseDTO village) {
        this.village = village;
    }

    @Override
    public String toString() {
        return "AddressDataResponse{" +
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
