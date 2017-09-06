package id.co.tripoin.core.dto.raw;

import id.co.tripoin.core.dto.response.AAuditTrailsResponseDTO;

/**
 * created on 2017-03-06
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class VillageRawDTO extends AAuditTrailsResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3719078891197227502L;

	private DistrictRawDTO district;

	public DistrictRawDTO getDistrict() {
		return district;
	}

	public void setDistrict(DistrictRawDTO district) {
		this.district = district;
	}

}
