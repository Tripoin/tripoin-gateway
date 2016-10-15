package id.co.tripoin.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Pageable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestPagination {

    private Pageable pageable;

    @JsonProperty("pageable")
    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
