package id.co.tripoin.core.dto.impl;

import id.co.tripoin.core.dto.ADATAMapper;
import id.co.tripoin.core.dto.raw.DistrictRawDTO;
import id.co.tripoin.core.dto.raw.VillageRawDTO;
import id.co.tripoin.core.pojo.master.village.Village;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created on 2017-03-06
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class VillageMapper extends ADATAMapper<Village, VillageRawDTO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(VillageMapper.class);
	
	@Override
	public VillageRawDTO convert(Village village) {
		VillageRawDTO result = null;
		try{
			result = new VillageRawDTO();
			result.setCode(village.getCode());
			result.setName(village.getName());
			result.setStatus(village.getStatus());
			result.setRemarks(village.getRemarks());
			result.setCreatedBy(village.getCreatedBy());
			result.setCreatedIP(village.getCreatedIP());
			result.setCreatedOn(village.getCreatedOn());
			result.setCreatedPlatform(village.getCreatedPlatform());
			result.setModifiedBy(village.getModifiedBy());
			result.setModifiedIP(village.getModifiedIP());
			result.setModifiedOn(village.getModifiedOn());
			result.setModifiedPlatform(village.getModifiedPlatform());
			if (village.getDistrict() != null){
				DistrictRawDTO district = new DistrictRawDTO();
				district.setId(village.getDistrict().getId());
				district.setCode(village.getDistrict().getCode());
				district.setName(village.getDistrict().getName());
				district.setStatus(village.getDistrict().getStatus());
				district.setRemarks(village.getDistrict().getRemarks());
				district.setCreatedBy(village.getDistrict().getCreatedBy());
				district.setCreatedIP(village.getDistrict().getCreatedIP());
				district.setCreatedOn(village.getDistrict().getCreatedOn());
				district.setCreatedPlatform(village.getDistrict().getCreatedPlatform());
				district.setModifiedBy(village.getDistrict().getModifiedBy());
				district.setModifiedIP(village.getDistrict().getModifiedIP());
				district.setModifiedOn(village.getDistrict().getModifiedOn());
				district.setModifiedPlatform(village.getDistrict().getModifiedPlatform());
				result.setDistrict(district);	
			}			
		}catch (Exception e) {
			LOGGER.error(e.toString());
		}
		return result;
	}

}
