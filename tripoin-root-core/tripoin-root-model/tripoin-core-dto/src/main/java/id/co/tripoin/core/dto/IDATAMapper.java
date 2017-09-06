package id.co.tripoin.core.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * created on 2/1/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <SOURCE>
 * @param <TARGET>
 */
public interface IDATAMapper<SOURCE, TARGET> extends Converter<SOURCE, TARGET> {

    List<TARGET> mapEntitiesIntoDTOs(Iterable<SOURCE> entities);

    Page<TARGET> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<SOURCE> source);
    
    SOURCE convertReverse(TARGET p_TARGET);
}
