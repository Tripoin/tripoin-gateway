package id.co.tripoin.core.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2/1/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <SOURCE>
 * @param <TARGET>
 */
public abstract class ADATAMapper<SOURCE, TARGET> implements IDATAMapper<SOURCE, TARGET> {

    @Override
    public List<TARGET> mapEntitiesIntoDTOs(Iterable<SOURCE> entities) {
        List<TARGET> listTarget = new ArrayList<>();
        for(SOURCE source : entities){
            listTarget.add(convert(source));
        }
        return listTarget;
    }

    @Override
    public Page<TARGET> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<SOURCE> source) {
        List<TARGET> targetList = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(targetList, pageRequest, source.getTotalElements());
    }

    @Override
    public SOURCE convertReverse(TARGET p_TARGET) {
        return null;
    }
    
}
