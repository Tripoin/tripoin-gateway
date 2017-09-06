package id.co.tripoin.core.integration.endpoint.client.base;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * created on 11/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <REQUEST_ENTITY>
 */
public abstract class ARestClient<DATA, REQUEST_ENTITY> implements IRestClient<DATA, REQUEST_ENTITY> {

    @Override
    public DATA queryClient(String urlToQuery){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(urlToQuery, getObjectResultClass());
    }

    @Override
    public DATA consume() {
        return null;
    }

    @Override
    public DATA queryClient(String p_UrlToQuery, MultiValueMap<String, String> p_HttpHeaders, Object p_ObjectToPass) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<REQUEST_ENTITY> entity = new HttpEntity(p_ObjectToPass, p_HttpHeaders);
        return restTemplate.postForObject(p_UrlToQuery, entity, getObjectResultClass());
    }

    public abstract Class<DATA> getObjectResultClass();
}
