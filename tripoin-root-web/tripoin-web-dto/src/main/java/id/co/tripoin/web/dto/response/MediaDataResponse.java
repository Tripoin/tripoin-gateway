package id.co.tripoin.web.dto.response;

import id.co.tripoin.web.dto.ResponseData;

import java.io.Serializable;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
public class MediaDataResponse extends ResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1975111553312154298L;

	private String apiTypeCode;
	private String apiTypeName;
	private String apiTypeIdentifier;
	private String apiTypeSecret;
	private String apiTypeHost;
	private String apiTypePort;
	private String apiTypeProtocol;
	private String apiTypeRedirect;
	private String apiTypeExpired;

	public String getApiTypeCode() {
		return apiTypeCode;
	}

	public void setApiTypeCode(String apiTypeCode) {
		this.apiTypeCode = apiTypeCode;
	}

	public String getApiTypeName() {
		return apiTypeName;
	}

	public void setApiTypeName(String apiTypeName) {
		this.apiTypeName = apiTypeName;
	}

	public String getApiTypeIdentifier() {
		return apiTypeIdentifier;
	}

	public void setApiTypeIdentifier(String apiTypeIdentifier) {
		this.apiTypeIdentifier = apiTypeIdentifier;
	}

	public String getApiTypeSecret() {
		return apiTypeSecret;
	}

	public void setApiTypeSecret(String apiTypeSecret) {
		this.apiTypeSecret = apiTypeSecret;
	}

	public String getApiTypeHost() {
		return apiTypeHost;
	}

	public void setApiTypeHost(String apiTypeHost) {
		this.apiTypeHost = apiTypeHost;
	}

	public String getApiTypePort() {
		return apiTypePort;
	}

	public void setApiTypePort(String apiTypePort) {
		this.apiTypePort = apiTypePort;
	}

	public String getApiTypeProtocol() {
		return apiTypeProtocol;
	}

	public void setApiTypeProtocol(String apiTypeProtocol) {
		this.apiTypeProtocol = apiTypeProtocol;
	}

	public String getApiTypeRedirect() {
		return apiTypeRedirect;
	}

	public void setApiTypeRedirect(String apiTypeRedirect) {
		this.apiTypeRedirect = apiTypeRedirect;
	}

	public String getApiTypeExpired() {
		return apiTypeExpired;
	}

	public void setApiTypeExpired(String apiTypeExpired) {
		this.apiTypeExpired = apiTypeExpired;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
