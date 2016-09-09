package id.co.tripoin.core.integration.security;

import id.co.tripoin.core.constant.statics.ApplicationContextConstant;
import id.co.tripoin.core.constant.statics.EncryptionConstant;
import id.co.tripoin.core.constant.statics.SystemParameterKeyConstant;
import id.co.tripoin.util.encryption.HmacGenerator;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	private ServletContext servletContext;
	
	private String plainKey;
	private String plainValue;
	
	public String getPlainKey() {
		return plainKey;
	}

	public void setPlainKey(String plainKey) {
		this.plainKey = plainKey;
	}

	public String getPlainValue() {
		return plainValue;
	}

	public void setPlainValue(String plainValue) {
		this.plainValue = plainValue;
	}

	/**
	 * <b>Sample Code:</b><br>
	 * <code>key</code><br>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String key(){
		try {
			Map<String, String> systemParameter = (Map<String, String>)servletContext.getAttribute(ApplicationContextConstant.CONTEXT_SYSTEM_PARAMETER);
			if(systemParameter.containsKey(SystemParameterKeyConstant.HEADER_KEY)){
				String plainDecrypt = new String(Base64.decodeBase64(systemParameter.get(SystemParameterKeyConstant.HEADER_KEY)));
				this.plainKey = plainDecrypt.split(":")[0];
				this.plainValue = plainDecrypt.split(":")[1];
				return HmacGenerator.hmac(plainKey, plainValue, EncryptionConstant.HMACMD5);
			}
			throw new Exception();
		} catch (Exception e) {
			return "";
		}
	}
	
}
