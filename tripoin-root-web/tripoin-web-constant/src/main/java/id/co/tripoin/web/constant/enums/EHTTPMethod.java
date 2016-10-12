package id.co.tripoin.web.constant.enums;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EHTTPMethod {

	POST("POST"),
	GET("GET"),
	PUT("PUT"),
	DELETE("DELETE"),
	OPTIONS("OPTIONS");

	private String method;
	
	private EHTTPMethod(String method){
		this.method = method;
	}

	@Override
	public String toString() {
		return method;
	}
	
}
