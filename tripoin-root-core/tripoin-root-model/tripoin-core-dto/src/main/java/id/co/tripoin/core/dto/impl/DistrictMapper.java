package id.co.tripoin.core.dto.impl;

import id.co.tripoin.core.dto.ADATAMapper;
import id.co.tripoin.core.dto.raw.CityRawDTO;
import id.co.tripoin.core.dto.raw.DistrictRawDTO;
import id.co.tripoin.core.pojo.master.district.District;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created on 2017-03-06
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DistrictMapper extends ADATAMapper<District, DistrictRawDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistrictMapper.class);

    @Override
    public DistrictRawDTO convert(District district) {
        DistrictRawDTO result = null;
        try {
            result = new DistrictRawDTO();
            result.setId(district.getId());
            result.setCode(district.getCode());
            result.setName(district.getName());
            result.setStatus(district.getStatus());
            result.setRemarks(district.getRemarks());
            result.setCreatedBy(district.getCreatedBy());
            result.setCreatedIP(district.getCreatedIP());
            result.setCreatedOn(district.getCreatedOn());
            result.setCreatedPlatform(district.getCreatedPlatform());
            result.setModifiedBy(district.getModifiedBy());
            result.setModifiedIP(district.getModifiedIP());
            result.setModifiedOn(district.getModifiedOn());
            result.setModifiedPlatform(district.getModifiedPlatform());
            if (district.getCity() != null) {
                CityRawDTO city = new CityRawDTO();
                city.setId(district.getCity().getId());
                city.setCode(district.getCity().getCode());
                city.setName(district.getCity().getName());
                city.setStatus(district.getCity().getStatus());
                city.setRemarks(district.getCity().getRemarks());
                city.setCreatedBy(district.getCity().getCreatedBy());
                city.setCreatedIP(district.getCity().getCreatedIP());
                city.setCreatedOn(district.getCity().getCreatedOn());
                city.setCreatedPlatform(district.getCity().getCreatedPlatform());
                city.setModifiedBy(district.getCity().getModifiedBy());
                city.setModifiedIP(district.getCity().getModifiedIP());
                city.setModifiedOn(district.getCity().getModifiedOn());
                city.setModifiedPlatform(district.getCity().getModifiedPlatform());
                result.setCity(city);
            } else {
                result.setCity(null);
                LOGGER.info("can not get City from district");
            }
//            if (district.getVillages().size() > 0) {
//                Set<VillageRawDTO> villages = new HashSet<>();
//                for (Village village : district.getVillages()) {
//                    VillageRawDTO villageRawDTO = new VillageRawDTO();
//                    villageRawDTO.setId(village.getId());
//                    villageRawDTO.setCode(village.getCode());
//                    villageRawDTO.setName(village.getName());
//                    villageRawDTO.setRemarks(village.getRemarks());
//                    villageRawDTO.setCreatedBy(village.getCreatedBy());
//                    villageRawDTO.setCreatedOn(village.getCreatedOn());
//                    villageRawDTO.setCreatedIP(village.getCreatedIP());
//                    villageRawDTO.setCreatedPlatform(village.getCreatedPlatform());
//                    villageRawDTO.setModifiedBy(village.getModifiedBy());
//                    villageRawDTO.setModifiedOn(village.getModifiedOn());
//                    villageRawDTO.setModifiedIP(village.getModifiedIP());
//                    villageRawDTO.setModifiedPlatform(village.getModifiedPlatform());
//                    villageRawDTO.setDistrict(result);
//                    villages.add(villageRawDTO);
//                }
//                result.setVillage(villages);
//            } else {
//                result.setVillage(null);
//                LOGGER.info("can not get Village from district");
//            }
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

}
