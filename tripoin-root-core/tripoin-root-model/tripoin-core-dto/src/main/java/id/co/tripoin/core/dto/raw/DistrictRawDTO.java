package id.co.tripoin.core.dto.raw;

import id.co.tripoin.core.dto.response.AAuditTrailsResponseDTO;

import java.util.Set;

/**
 * created on 2017-03-06
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DistrictRawDTO extends AAuditTrailsResponseDTO {

    /**
     *
     */
    private static final long serialVersionUID = -4926802174306076832L;

    private CityRawDTO city;
    private Set<VillageRawDTO> village;

    public CityRawDTO getCity() {
        return city;
    }

    public void setCity(CityRawDTO city) {
        this.city = city;
    }

    public Set<VillageRawDTO> getVillage() {
        return village;
    }

    public void setVillage(Set<VillageRawDTO> village) {
        this.village = village;
    }

}
