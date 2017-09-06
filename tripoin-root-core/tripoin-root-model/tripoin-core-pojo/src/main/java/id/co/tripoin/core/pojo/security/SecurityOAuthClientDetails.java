package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = TableNameConstant.Security.SEC_OAUTH_CLIENT_DETAILS)
public class SecurityOAuthClientDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4884916771334035968L;
	private Long id;
	private String clientId;
	private String resourceId;
	private String clientSecret;
	private String scope;
	private String authorizedGrantTypes;
	private String webServerRedirectUri;
	private String authorities;
	private Integer accessTokenValidity;
	private Integer refreshTokenValidity;
	private String additionalInformation;
	private String autoApprove;
		

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "client_id", unique = true)
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	@Column(name = "resource_ids")
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	@Column(name = "client_secret")
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	@Column(name = "scope")
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	@Column(name = "authorized_grant_types")
	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}
	
	@Column(name = "web_server_redirect_uri")
	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}
	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}
	
	@Column(name = "authorities")
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	
	@Column(name = "access_token_validity")
	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}
	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}
	
	@Column(name = "refresh_token_validity")
	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}
	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}
	
	@Column(name = "additional_information")
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	
	@Column(name = "autoapprove")
	public String getAutoApprove() {
		return autoApprove;
	}
	public void setAutoApprove(String autoApprove) {
		this.autoApprove = autoApprove;
	}
	@Override
	public String toString() {
		return "SecurityOAuthClientDetails [clientId=" + clientId + ", resourceId=" + resourceId + ", clientSecret="
				+ clientSecret + ", scope=" + scope + ", authorizedGrantTypes=" + authorizedGrantTypes
				+ ", webServerRedirectUri=" + webServerRedirectUri + ", authorities=" + authorities
				+ ", accessTokenValidity=" + accessTokenValidity + ", refreshTokenValidity=" + refreshTokenValidity
				+ ", additionalInformation=" + additionalInformation + ", autoApprove=" + autoApprove + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessTokenValidity == null) ? 0 : accessTokenValidity.hashCode());
		result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
		result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
		result = prime * result + ((authorizedGrantTypes == null) ? 0 : authorizedGrantTypes.hashCode());
		result = prime * result + ((autoApprove == null) ? 0 : autoApprove.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientSecret == null) ? 0 : clientSecret.hashCode());
		result = prime * result + ((refreshTokenValidity == null) ? 0 : refreshTokenValidity.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result + ((webServerRedirectUri == null) ? 0 : webServerRedirectUri.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecurityOAuthClientDetails other = (SecurityOAuthClientDetails) obj;
		if (accessTokenValidity == null) {
			if (other.accessTokenValidity != null)
				return false;
		} else if (!accessTokenValidity.equals(other.accessTokenValidity))
			return false;
		if (additionalInformation == null) {
			if (other.additionalInformation != null)
				return false;
		} else if (!additionalInformation.equals(other.additionalInformation))
			return false;
		if (authorities == null) {
			if (other.authorities != null)
				return false;
		} else if (!authorities.equals(other.authorities))
			return false;
		if (authorizedGrantTypes == null) {
			if (other.authorizedGrantTypes != null)
				return false;
		} else if (!authorizedGrantTypes.equals(other.authorizedGrantTypes))
			return false;
		if (autoApprove == null) {
			if (other.autoApprove != null)
				return false;
		} else if (!autoApprove.equals(other.autoApprove))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientSecret == null) {
			if (other.clientSecret != null)
				return false;
		} else if (!clientSecret.equals(other.clientSecret))
			return false;
		if (refreshTokenValidity == null) {
			if (other.refreshTokenValidity != null)
				return false;
		} else if (!refreshTokenValidity.equals(other.refreshTokenValidity))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (scope == null) {
			if (other.scope != null)
				return false;
		} else if (!scope.equals(other.scope))
			return false;
		if (webServerRedirectUri == null) {
			if (other.webServerRedirectUri != null)
				return false;
		} else if (!webServerRedirectUri.equals(other.webServerRedirectUri))
			return false;
		return true;
	}
	
	
}
