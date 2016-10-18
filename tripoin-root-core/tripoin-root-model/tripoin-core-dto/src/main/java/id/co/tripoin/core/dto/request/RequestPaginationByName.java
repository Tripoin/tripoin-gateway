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
public class RequestPaginationByName extends DTOPagination{

    private static final long serialVersionUID = 5328323003527580770L;
    private String name;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
