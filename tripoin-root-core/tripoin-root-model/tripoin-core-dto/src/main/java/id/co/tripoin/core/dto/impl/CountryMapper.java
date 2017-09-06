package id.co.tripoin.core.dto.impl;


import id.co.tripoin.core.dto.ADATAMapper;
import id.co.tripoin.core.dto.raw.CountryRawDTO;
import id.co.tripoin.core.pojo.master.country.Country;

/**
 * created on 2017-03-19
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CountryMapper extends ADATAMapper<Country, CountryRawDTO> {

	@Override
	public CountryRawDTO convert(Country p_Country) {
		CountryRawDTO result = new CountryRawDTO();
		result.setId(p_Country.getId());
		result.setCode(p_Country.getCode());
		result.setName(p_Country.getName());
		result.setStatus(p_Country.getStatus());
		result.setRemarks(p_Country.getRemarks());
		result.setCreatedBy(p_Country.getCreatedBy());
		result.setCreatedIP(p_Country.getCreatedIP());
		result.setCreatedOn(p_Country.getCreatedOn());
		result.setCreatedPlatform(p_Country.getCreatedPlatform());
		result.setModifiedBy(p_Country.getModifiedBy());
		result.setModifiedIP(p_Country.getModifiedIP());
		result.setModifiedOn(p_Country.getModifiedOn());
		result.setModifiedPlatform(p_Country.getModifiedPlatform());
		return result;
	}

}
