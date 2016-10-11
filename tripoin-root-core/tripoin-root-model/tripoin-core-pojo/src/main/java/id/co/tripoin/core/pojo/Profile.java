package id.co.tripoin.core.pojo;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name=TableNameConstant.Security.MST_PROFILE)
public class Profile extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1886133679857135012L;

	private Long id;
    private String email;
    private String code;
    private String name;
    private String gender;
    private Date birthdate;
    private String address;
    private String phone;
    private String photo;
    private String bio;
    private String resourcesUUID;
    private String forgotUUID;
    private Timestamp forgotExpired;
    private User user;
    private I18NLocale i18NLocale;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="profile_id")
    @Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="profile_email", unique=true, length=150)
    @NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="profile_code", length=150)
	@Override
	public String getCode() {
		return code;
	}

	@Column(name="profile_name", length=150)
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="profile_gender", length=10)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="profile_birthdate")
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setBirthdate(java.util.Date birthdate) {
		this.birthdate = new Date(birthdate.getTime());
	}

	@Column(name="profile_address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="profile_phone", unique=true, length=20)
    @NotNull
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="profile_photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name="profile_bio")
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Column(name="profile_resources_uuid")
	public String getResourcesUUID() {
		return resourcesUUID;
	}

	public void setResourcesUUID(String resourcesUUID) {
		this.resourcesUUID = resourcesUUID;
	}

	@Column(name="profile_forgot_uuid")
	public String getForgotUUID() {
		return forgotUUID;
	}

	public void setForgotUUID(String forgotUUID) {
		this.forgotUUID = forgotUUID;
	}

	@Column(name="profile_forgot_expired")
	public Timestamp getForgotExpired() {
		return forgotExpired;
	}

	public void setForgotExpired(Timestamp forgotExpired) {
		this.forgotExpired = forgotExpired;
	}

	public void setForgotExpired(java.util.Date forgotExpired) {
		this.forgotExpired = new Timestamp(forgotExpired.getTime());
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locale_id", nullable = false)
	public I18NLocale getI18NLocale() {
		return i18NLocale;
	}

	public void setI18NLocale(I18NLocale i18nLocale) {
		i18NLocale = i18nLocale;
	}

	@Override
	public String tableName() {
		return TableNameConstant.Security.MST_PROFILE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profile [email=" + email + ", name=" + name + ", phone=" + phone + "]";
	}	

}
