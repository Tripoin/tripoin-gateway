package id.co.tripoin.core.pojo;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
@Entity
@Table(name=TableNameConstant.Master.MST_API_TYPE)
public class APIType extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244317712417803145L;
	
	private Long id;
    private String code;
    private String name;
    private String apiTypeIdentifier;
    private String apiTypeSecret;
    private String apiTypeHost;
    private String apiTypePort;
    private String apiTypeProtocol;
    private String apiTypeRedirect;
    private String apiTypeExpired;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="api_type_id")
	@Override
	public Long getId() {
		return id;
	}    
    
    public void setId(Long id) {
		this.id = id;
	}


	@Column(name="api_type_code", unique=true, length=150)
	@Override
	public String getCode() {
		return code;
	}

	@Column(name="api_type_name", unique=true, length=255)
	@Override
	public String getName() {
		return name;
	}		

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="api_type_identifier", unique=true, length=150)
    @NotNull
	public String getApiTypeIdentifier() {
		return apiTypeIdentifier;
	}

	public void setApiTypeIdentifier(String apiTypeIdentifier) {
		this.apiTypeIdentifier = apiTypeIdentifier;
	}

	@Column(name="api_type_secret", unique=true, length=150)
    @NotNull
	public String getApiTypeSecret() {
		return apiTypeSecret;
	}

	public void setApiTypeSecret(String apiTypeSecret) {
		this.apiTypeSecret = apiTypeSecret;
	}

	@Column(name="api_type_host", unique=true, length=150)
    @NotNull
	public String getApiTypeHost() {
		return apiTypeHost;
	}

	public void setApiTypeHost(String apiTypeHost) {
		this.apiTypeHost = apiTypeHost;
	}

	@Column(name="api_type_port", unique=true, length=150)
    @NotNull
	public String getApiTypePort() {
		return apiTypePort;
	}

	
	public void setApiTypePort(String apiTypePort) {
		this.apiTypePort = apiTypePort;
	}

	@Column(name="api_type_protocol", unique=true, length=150)
    @NotNull
	public String getApiTypeProtocol() {
		return apiTypeProtocol;
	}

	public void setApiTypeProtocol(String apiTypeProtocol) {
		this.apiTypeProtocol = apiTypeProtocol;
	}

	@Column(name="api_type_redirect", unique=true, length=150)
    @NotNull
	public String getApiTypeRedirect() {
		return apiTypeRedirect;
	}

	public void setApiTypeRedirect(String apiTypeRedirect) {
		this.apiTypeRedirect = apiTypeRedirect;
	}

	@Column(name="api_type_expired", unique=true, length=150)
    @NotNull
	public String getApiTypeExpired() {
		return apiTypeExpired;
	}

	public void setApiTypeExpired(String apiTypeExpired) {
		this.apiTypeExpired = apiTypeExpired;
	}

	@Override
	public String tableName() {
		// TODO Auto-generated method stub
		return TableNameConstant.Master.MST_API_TYPE;
	}

	

}
