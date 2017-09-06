package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;

import javax.persistence.*;
import java.util.Date;


/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */

@Entity
@Table(name = TableNameConstant.Security.SEC_USER_VERIFICATION)
public class SecurityUserVerification {

	private Long id;
	private String token;
	private Date expiryDate;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "token")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Column(name = "expiry_date")
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SecurityUserVerification [id=" + id + ", token=" + token + ", expiryDate=" + expiryDate + ", user="
				+ user + "]";
	}
	
	
}
