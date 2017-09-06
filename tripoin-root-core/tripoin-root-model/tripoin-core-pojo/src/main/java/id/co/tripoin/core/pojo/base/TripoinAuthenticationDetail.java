package id.co.tripoin.core.pojo.base;

import id.co.tripoin.core.dto.TripoinAuthenticationDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TripoinAuthenticationDetail extends WebAuthenticationDetails {
    private static final long serialVersionUID = -5494857241468322476L;
    private static final Logger LOGGER = LoggerFactory.getLogger(TripoinAuthenticationDetail.class);
    private TripoinAuthenticationDetailDTO tripoinAuthenticationDetailDTO;
    /**
     * Records the remote address and will also set the session Id if a session
     * already exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public TripoinAuthenticationDetail(HttpServletRequest request) {
        super(request);
        tripoinAuthenticationDetailDTO = new TripoinAuthenticationDetailDTO();
        tripoinAuthenticationDetailDTO.setPlatform(request.getHeader("User-Agent"));
        tripoinAuthenticationDetailDTO.setIpAddress(request.getHeader("X-FORWARDED-FOR"));
        if (tripoinAuthenticationDetailDTO.getIpAddress() == null) {
            tripoinAuthenticationDetailDTO.setIpAddress(request.getRemoteAddr());
        }
    }

    public TripoinAuthenticationDetailDTO getTripoinAuthenticationDetailDTO() {
        return tripoinAuthenticationDetailDTO;
    }

    public void setTripoinAuthenticationDetailDTO(TripoinAuthenticationDetailDTO tripoinAuthenticationDetailDTO) {
        this.tripoinAuthenticationDetailDTO = tripoinAuthenticationDetailDTO;
    }
}
