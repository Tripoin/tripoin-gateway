package id.co.tripoin.core.dto.raw;

import id.co.tripoin.core.dto.response.AAuditTrailsResponseDTO;

import java.io.Serializable;

/**
 * Created on 4/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UserRawDTO extends AAuditTrailsResponseDTO implements Serializable {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 5421997144967549708L;
    
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
