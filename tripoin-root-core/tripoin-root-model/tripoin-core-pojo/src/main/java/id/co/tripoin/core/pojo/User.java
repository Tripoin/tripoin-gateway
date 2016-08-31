package id.co.tripoin.core.pojo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import id.co.tripoin.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.IBasePojo;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name=TableNameConstant.SEC_USER_DETAILS)
public class User implements IBasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8562964002269118022L;
	private Integer id;
	private String username;
	private Integer enabled;
	private Timestamp expiredDate;
	private Timestamp credentialsExpiredDate;
	private Integer nonLocked;
	private Role role;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "client_id", unique=true, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "user_enabled")
	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Column(name = "user_expired_date")
	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		if(expiredDate != null)
			this.expiredDate = new Timestamp(expiredDate.getTime());
	}

	@Column(name = "user_credentials_expired_date")
	public Timestamp getCredentialsExpiredDate() {
		return credentialsExpiredDate;
	}

	public void setCredentialsExpiredDate(Timestamp credentialsExpiredDate) {
		this.credentialsExpiredDate = credentialsExpiredDate;
	}

	public void setCredentialsExpiredDate(Date credentialsExpiredDate) {
		if(credentialsExpiredDate != null)
			this.credentialsExpiredDate = new Timestamp(credentialsExpiredDate.getTime());
	}

	@Column(name = "user_non_locked")
	public Integer getNonLocked() {
		return nonLocked;
	}

	public void setNonLocked(Integer nonLocked) {
		this.nonLocked = nonLocked;
	}

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String tableName() {
		return TableNameConstant.SEC_USER_DETAILS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}

}
