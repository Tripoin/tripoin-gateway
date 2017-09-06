package id.co.tripoin.core.dto.impl;


import id.co.tripoin.core.dto.ADATAMapper;
import id.co.tripoin.core.dto.raw.ProvinceRawDTO;
import id.co.tripoin.core.pojo.master.province.Province;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created on 2017-03-06
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProvinceMapper extends ADATAMapper<Province, ProvinceRawDTO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinceMapper.class);
	
	@Override
	public ProvinceRawDTO convert(Province province) {
		ProvinceRawDTO result = null;
		try{
			result = new ProvinceRawDTO();
			result.setId(province.getId());
			result.setCode(province.getCode());
			result.setName(province.getName());
			result.setStatus(province.getStatus());
			result.setRemarks(province.getRemarks());
			result.setCreatedBy(province.getCreatedBy());
			result.setCreatedIP(province.getCreatedIP());
			result.setCreatedOn(province.getCreatedOn());
			result.setCreatedPlatform(province.getCreatedPlatform());
			result.setModifiedBy(province.getModifiedBy());
			result.setModifiedIP(province.getModifiedIP());
			result.setModifiedOn(province.getModifiedOn());
			result.setModifiedPlatform(province.getModifiedPlatform());
		}catch (Exception e) {
			LOGGER.error(e.toString());
		}
		return result;
	}

}
