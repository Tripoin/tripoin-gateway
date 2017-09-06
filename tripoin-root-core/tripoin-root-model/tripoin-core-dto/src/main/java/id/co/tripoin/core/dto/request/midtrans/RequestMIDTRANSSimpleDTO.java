package id.co.tripoin.core.dto.request.midtrans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestMIDTRANSSimpleDTO implements Serializable{

    private static final long serialVersionUID = 3055562366685483450L;

    @JsonProperty(value = "transaction_details")
    private RequestContentMIDTRANSSimpleDTO transaction_details;

    public RequestContentMIDTRANSSimpleDTO getTransaction_details() {
        return transaction_details;
    }

    public void setTransaction_details(RequestContentMIDTRANSSimpleDTO transaction_details) {
        this.transaction_details = transaction_details;
    }

    @Override
    public String toString() {
        return "RequestMIDTRANSSimpleDTO{" +
                "transaction_details=" + transaction_details +
                '}';
    }
}
