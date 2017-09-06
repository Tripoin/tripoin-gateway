package id.co.tripoin.core.dto.request;

import java.io.Serializable;

public class RequestUpdateProfileDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3813717680715551022L;

	private String userName;
	private String name;
	private String id;
	private RequestUpdateContactDTO contact;
	private RequestUpdateAddresDTO address;
	private Integer locale;
	private Integer gender;
	private String birthDate;
	private String birthPlace;
	private String profilePhoto;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RequestUpdateContactDTO getContact() {
		return contact;
	}

	public void setContact(RequestUpdateContactDTO contact) {
		this.contact = contact;
	}

	public RequestUpdateAddresDTO getAddress() {
		return address;
	}

	public void setAddress(RequestUpdateAddresDTO address) {
		this.address = address;
	}

	public Integer getLocale() {
		return locale;
	}

	public void setLocale(Integer locale) {
		this.locale = locale;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Override
	public String toString() {
		return "RequestUpdateProfileDTO{" +
				"name='" + name + '\'' +
				", contact=" + contact +
				", address=" + address +
				", locale=" + locale +
				", gender=" + gender +
				", birthDate='" + birthDate + '\'' +
				", profilePhoto='" + profilePhoto + '\'' +
				'}';
	}
}
