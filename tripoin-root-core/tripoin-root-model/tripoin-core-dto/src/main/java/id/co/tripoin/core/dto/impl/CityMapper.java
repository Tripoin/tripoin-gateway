package id.co.tripoin.core.dto.impl;

import id.co.tripoin.core.dto.ADATAMapper;
import id.co.tripoin.core.dto.raw.CityRawDTO;
import id.co.tripoin.core.dto.raw.DistrictRawDTO;
import id.co.tripoin.core.dto.raw.ProvinceRawDTO;
import id.co.tripoin.core.pojo.master.city.City;
import id.co.tripoin.core.pojo.master.district.District;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * created on 2017-03-06
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CityMapper extends ADATAMapper<City, CityRawDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityMapper.class);

    @Override
    public CityRawDTO convert(City city) {
        CityRawDTO result = null;
        try {
            result = new CityRawDTO();
            result.setId(city.getId());
            result.setCode(city.getCode());
            result.setName(city.getName());
            result.setStatus(city.getStatus());
            result.setRemarks(city.getRemarks());
            result.setCreatedBy(city.getCreatedBy());
            result.setCreatedIP(city.getCreatedIP());
            result.setCreatedOn(city.getCreatedOn());
            result.setCreatedPlatform(city.getCreatedPlatform());
            result.setModifiedBy(city.getModifiedBy());
            result.setModifiedIP(city.getModifiedIP());
            result.setModifiedOn(city.getModifiedOn());
            result.setModifiedPlatform(city.getModifiedPlatform());
            if (city.getDistricts().size() > 0) {
                Set<DistrictRawDTO> districtRawDTOs = new HashSet<>();
                for (District district : city.getDistricts()) {
                    DistrictRawDTO districtRawDTO = new DistrictRawDTO();
                    districtRawDTO.setId(district.getId());
                    districtRawDTO.setCode(district.getCode());
                    districtRawDTO.setName(district.getName());
                    districtRawDTO.setStatus(district.getStatus());
                    districtRawDTO.setRemarks(district.getRemarks());
                    districtRawDTO.setCreatedBy(district.getCreatedBy());
                    districtRawDTO.setCreatedIP(district.getCreatedIP());
                    districtRawDTO.setCreatedOn(district.getCreatedOn());
                    districtRawDTO.setCreatedPlatform(district.getCreatedPlatform());
                    districtRawDTO.setModifiedBy(district.getModifiedBy());
                    districtRawDTO.setModifiedIP(district.getModifiedIP());
                    districtRawDTO.setModifiedOn(district.getModifiedOn());
                    districtRawDTO.setModifiedPlatform(district.getModifiedPlatform());
                    districtRawDTOs.add(districtRawDTO);
                }
                result.setDistrict(districtRawDTOs);
            }
            if (city.getProvince() != null) {
                ProvinceRawDTO province = new ProvinceRawDTO();
                province.setId(city.getProvince().getId());
                province.setCode(city.getProvince().getCode());
                province.setName(city.getProvince().getName());
                province.setStatus(city.getProvince().getStatus());
                province.setRemarks(city.getProvince().getRemarks());
                province.setCreatedBy(city.getProvince().getCreatedBy());
                province.setCreatedIP(city.getProvince().getCreatedIP());
                province.setCreatedOn(city.getProvince().getCreatedOn());
                province.setCreatedPlatform(city.getProvince().getCreatedPlatform());
                province.setModifiedBy(city.getProvince().getModifiedBy());
                province.setModifiedIP(city.getProvince().getModifiedIP());
                province.setModifiedOn(city.getProvince().getModifiedOn());
                province.setModifiedPlatform(city.getProvince().getModifiedPlatform());
                result.setProvince(province);
            }
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

}
