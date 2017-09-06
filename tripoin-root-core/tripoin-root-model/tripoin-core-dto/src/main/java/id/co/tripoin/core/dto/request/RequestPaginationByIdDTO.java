package id.co.tripoin.core.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class RequestPaginationByIdDTO extends PaginationDTO{
    
    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = 8233011880584230217L;
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
