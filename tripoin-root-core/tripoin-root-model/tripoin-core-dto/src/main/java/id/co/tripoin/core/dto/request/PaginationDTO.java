package id.co.tripoin.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * created on 10/16/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class PaginationDTO implements Serializable {

    private static final long serialVersionUID = -5212503591304603360L;
    private Integer offset;
    private Integer limit;
    private String order;
    private String sort;

    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "DTOPagination{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", order='" + order + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
