package id.co.tripoin.core.integration.endpoint.client.midtrans;

import id.co.tripoin.core.constant.statics.CommonConstant;
import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.midtrans.RequestMIDTRANSCompleteDTO;
import id.co.tripoin.core.dto.request.midtrans.RequestMIDTRANSSimpleDTO;
import id.co.tripoin.core.dto.response.midtrans.SnapTokenResponseDTO;
import id.co.tripoin.core.integration.endpoint.client.base.ARestClient;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MIDTRANSClient extends ARestClient<SnapTokenResponseDTO, RequestMIDTRANSSimpleDTO> implements IMIDTRANSClient {

    @Value("${eth.midtrans.serverkey}")
    private String serverKey;

    @Value("${eth.midtrans.password}")
    private String password;

    private static final Logger LOGGER = LoggerFactory.getLogger(MIDTRANSClient.class);

    @Override
    public Class<SnapTokenResponseDTO> getObjectResultClass() {
        return SnapTokenResponseDTO.class;
    }

    @Override
    public SnapTokenResponseDTO simpleTransaction(RequestMIDTRANSSimpleDTO p_RequestMIDTRANSSimpleDTO) {
        SnapTokenResponseDTO snapTokenResponseDTO = new SnapTokenResponseDTO();
        try {
            snapTokenResponseDTO = queryClient(PathNameConstant.MidTrans.SANDBOX, getMidtransRequiredHeaders(), p_RequestMIDTRANSSimpleDTO);
        } catch (Exception e) {
            LOGGER.error("error receiving MIDTRANS token : " + e.toString());
        }
        return snapTokenResponseDTO;
    }

    @Override
    public SnapTokenResponseDTO completeTransaction(RequestMIDTRANSCompleteDTO p_RequestMIDTRANSCompleteDTO) {
        SnapTokenResponseDTO snapTokenResponseDTO = new SnapTokenResponseDTO();
        try {
            snapTokenResponseDTO = queryClient(PathNameConstant.MidTrans.SANDBOX, getMidtransRequiredHeaders(), p_RequestMIDTRANSCompleteDTO);
        } catch (Exception e) {
            LOGGER.error("error receiving MIDTRANS token : " + e.toString());
        }
        return snapTokenResponseDTO;
    }

    private MultiValueMap<String, String> getMidtransRequiredHeaders() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.set("Authorization", "Basic ".concat(new String(Base64.encodeBase64((serverKey.concat(CommonConstant.Punctuation.COLON).concat(password)).getBytes()))));
        return headers;
    }
}
