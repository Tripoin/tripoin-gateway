package id.co.tripoin.web.dto.response;

import id.co.tripoin.web.dto.ResponseData;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class ProfileDataResponse extends ResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4419407064986008496L;

	private String email;
	private String username;
	private String name;
	private String gender;
	private Date birthdate;
	private String address;
	private String phone;
	private String photo;
	private String bio;
	private RoleDataResponse authority;
	private I18NLocaleDataResponse locale;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public RoleDataResponse getAuthority() {
		return authority;
	}

	public void setAuthority(RoleDataResponse authority) {
		this.authority = authority;
	}

	public I18NLocaleDataResponse getLocale() {
		return locale;
	}

	public void setLocale(I18NLocaleDataResponse locale) {
		this.locale = locale;
	}

}
