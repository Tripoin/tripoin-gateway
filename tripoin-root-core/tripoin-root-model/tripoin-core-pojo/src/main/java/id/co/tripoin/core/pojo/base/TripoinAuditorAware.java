package id.co.tripoin.core.pojo.base;


import id.co.tripoin.core.constant.statics.CommonConstant;
import id.co.tripoin.core.dto.TripoinAuthenticationDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TripoinAuditorAware implements AuditorAware<TripoinAuthenticationDetailDTO> {

	@Autowired
    TripoinAuthenticationDetailDTO tripoinAuthenticationDetailDTO;
	
    @Override
    public TripoinAuthenticationDetailDTO getCurrentAuditor() {
        try{
        	TripoinAuthenticationDetail tripoinAuthenticationDetail = (TripoinAuthenticationDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
            tripoinAuthenticationDetailDTO = tripoinAuthenticationDetail.getTripoinAuthenticationDetailDTO();
            tripoinAuthenticationDetailDTO.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
            return tripoinAuthenticationDetailDTO;
        }catch (Exception e) {
        	TripoinAuthenticationDetailDTO authenticationDetailDTO = new TripoinAuthenticationDetailDTO();
        	authenticationDetailDTO.setUserName(CommonConstant.PUBLIC_USER);
			return authenticationDetailDTO;
		}
    }
}
