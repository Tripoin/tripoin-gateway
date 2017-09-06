package id.co.tripoin.core.dto.raw;

import id.co.tripoin.core.dto.response.AAuditTrailsResponseDTO;

import java.util.Set;

/**
 * created on 2017-03-06
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CityRawDTO extends AAuditTrailsResponseDTO {

    /**
     *
     */
    private static final long serialVersionUID = -7553437430707959212L;
    private ProvinceRawDTO province;
    private Set<DistrictRawDTO> district;

    public Set<DistrictRawDTO> getDistrict() {
        return district;
    }

    public void setDistrict(Set<DistrictRawDTO> district) {
        this.district = district;
    }

    public ProvinceRawDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceRawDTO province) {
        this.province = province;
    }

}
