package id.co.tripoin.core.service.scaffolding;

import id.co.tripoin.core.dto.TripoinAuthenticationDetailDTO;
/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IScaffoldingService<DATA> extends IInquiryService<DATA, Long>, ITransactionService<DATA, Long> {
    void setAuthenticationDTO(TripoinAuthenticationDetailDTO p_TripoinAuthenticationDetailDTO);

    String generateRandomCode();
}