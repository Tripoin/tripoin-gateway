package id.co.tripoin.core.integration.endpoint.client.midtrans;

import id.co.tripoin.core.dto.request.midtrans.RequestMIDTRANSCompleteDTO;
import id.co.tripoin.core.dto.request.midtrans.RequestMIDTRANSSimpleDTO;
import id.co.tripoin.core.dto.response.midtrans.SnapTokenResponseDTO;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IMIDTRANSClient {

    SnapTokenResponseDTO simpleTransaction(RequestMIDTRANSSimpleDTO p_RequestMIDTRANSSimpleDTO);

    SnapTokenResponseDTO completeTransaction(RequestMIDTRANSCompleteDTO p_RequestMIDTRANSCompleteDTO);
}
