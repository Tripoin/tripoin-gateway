package id.co.tripoin.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * created on 11/2/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestID implements Serializable {
    private static final long serialVersionUID = 5127341185304391350L;

    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestID{" +
                "id=" + id +
                '}';
    }
}
