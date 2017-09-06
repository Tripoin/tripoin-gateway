package id.co.tripoin.core.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@Scope("session")
public class TripoinAuthenticationDetailDTO implements Serializable{

    private static final long serialVersionUID = -5319037526372148506L;

    private String platform;
    private String ipAddress;
    private String userName;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "EthAuthenticationDetailDTO{" +
                "platform='" + platform + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
