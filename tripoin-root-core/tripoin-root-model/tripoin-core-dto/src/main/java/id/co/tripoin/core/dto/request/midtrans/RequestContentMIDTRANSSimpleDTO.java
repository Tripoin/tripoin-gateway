package id.co.tripoin.core.dto.request.midtrans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestContentMIDTRANSSimpleDTO implements Serializable {

    private static final long serialVersionUID = 4691218217035329936L;

    @JsonProperty("order_id")
    private String order_id;

    @JsonProperty("gross_amount")
    private String gross_amount;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getGross_amount() {
        return gross_amount;
    }

    public void setGross_amount(String gross_amount) {
        this.gross_amount = gross_amount;
    }

    @Override
    public String toString() {
        return "RequestContentMIDTRANSSimpleDTO{" +
                "order_id='" + order_id + '\'' +
                ", gross_amount='" + gross_amount + '\'' +
                '}';
    }
}
