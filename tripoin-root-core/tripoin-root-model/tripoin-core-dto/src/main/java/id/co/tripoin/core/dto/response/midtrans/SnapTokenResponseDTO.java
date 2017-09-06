package id.co.tripoin.core.dto.response.midtrans;

import java.io.Serializable;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SnapTokenResponseDTO implements Serializable{

    private static final long serialVersionUID = 86541928800861592L;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	@Override
	public String toString() {
		return "SnapTokenResponseDTO [token=" + token + "]";
	}
    
    
}
