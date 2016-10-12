package id.co.tripoin.web.service.security;

import org.springframework.beans.factory.annotation.Value;

import id.co.tripoin.util.encryption.HmacGenerator;
import id.co.tripoin.web.constant.statics.EncryptionConstant;
import id.co.tripoin.web.constant.statics.ResourcePropertiesConstant;

/**
 * <b>Algorithm Encription X-Tripoin-Key:</b></br>
 * &emsp;&emsp;&emsp;Param Key = <b>P@ssw0rd</b> <i>from resources.properties ${tripoin.api.header.key}</i></br>
 * &emsp;&emsp;&emsp;Param Value = <b>P@ssw0rd</b> <i>from resources.properties ${tripoin.api.header.value}</i></br></br>
 * &emsp;&emsp;&emsp;Result = <i>HmacGenerator.hmac(</i><b>Param Key</b>, <b>Param Value</b><i>, "HmacMD5")</i></br>
 * &emsp;&emsp;&emsp;Value = <b>85adc8e352ddf41c0cf4a08ecf93085f</b></br>
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class HeaderKeyGenerator {
	
	@Value(ResourcePropertiesConstant.PLAIN_HEADER_KEY)
	private String plainKey;

	@Value(ResourcePropertiesConstant.PLAIN_HEADER_VALUE)
	private String plainValue;

	/**
	 * <b>Sample Code:</b><br>
	 * <code>key</code><br>
	 * @return
	 */
	public String key(){
		return HmacGenerator.hmac(this.plainKey, this.plainValue, EncryptionConstant.HMACMD5);
	}
	
}
