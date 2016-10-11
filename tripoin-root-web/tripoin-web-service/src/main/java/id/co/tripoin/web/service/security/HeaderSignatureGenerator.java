package id.co.tripoin.web.service.security;

import id.co.tripoin.util.encryption.HexSHA256Generator;
import id.co.tripoin.util.encryption.HmacGenerator;
import id.co.tripoin.web.constant.statics.EncryptionConstant;

/**
 * <b>Algorithm Encription X-Tripoin-Signature:</b></br>
 * &emsp;&emsp;&emsp;Method HTTP = <b>POST</b>, <b>GET</b>, <b>DELETE</b>, or <b>PUT</b></br>
 * &emsp;&emsp;&emsp;Path = <b>/api/sample/service</b> <i>from URI (http://www.tripoin.co.id/api/sample/service)</i></br>
 * &emsp;&emsp;&emsp;Access Token = <b>090e6577-0531-4917-8659-ad97f0585b34</b> <i>from Authorization : Bearer 090e6577-0531-4917-8659-ad97f0585b34</i></br>
 * &emsp;&emsp;&emsp;HexSHA256 Body = <b>414e2b2c627b55a2aa27ef0f143cadfc8ec994bc25d8cedaf514b088bd5d772c</b> <i>from HexSHA256Generator.hexSha256("{\"currencyCode\":\"IDR\"}")</i></br>
 * &emsp;&emsp;&emsp;Timestamp = <b>2016-02-03T10:00:00.000+07:00</b> <i>from X-Tripoin-Timestamp : 2016-02-03T10:00:00.000+07:00</i></br>
 * &emsp;&emsp;&emsp;API Key = <b>85adc8e352ddf41c0cf4a08ecf93085f</b> <i>from X-Tripoin-Key : 85adc8e352ddf41c0cf4a08ecf93085f</i></br></br>
 * &emsp;&emsp;&emsp;Result = <i>SignatureHeader.hmacSha256(</i><b>API Key</b>, <b>Method HTTP</b> + <b>Path</b> + <b>Access Token</b> + <b>HexSHA256 Body</b> + <b>Timestamp</b><i>)</i></br>
 * &emsp;&emsp;&emsp;Value = <b>acb476a3ad5940f8e790154f5033f1e853a6ba4fac4da03230fe4c4b86f6ad0c</b></br>
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class HeaderSignatureGenerator {

    public static String hmacSha256(String KEY, String VALUE) {
        return HmacGenerator.hmac(KEY, VALUE, EncryptionConstant.HMACSHA256);
    }
    
    public static String signature(String apiKey, String accessToken, String method, String body, String path, String timestamp){
    	String plainSign = method.concat(":").
    			concat(path).concat(":").
    			concat(accessToken).concat(":").
    			concat(HexSHA256Generator.hexSha256(body)).concat(":").
    			concat(timestamp);
    	return HeaderSignatureGenerator.hmacSha256(apiKey, plainSign);
    }
	
	public static void main(String[] args) {
		//SAMPLE SIGNATURE
		String data = "{\"currencyCode\":\"IDR\"}";
        System.out.println(signature("85adc8e352ddf41c0cf4a08ecf93085f", 
        		"090e6577-0531-4917-8659-ad97f0585b34", 
        		"POST", data, "/api/sample/service", "2016-02-03T10:00:00.000+07:00"));
    }
	
}
