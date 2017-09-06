package id.co.tripoin.core.dto.response;

import id.co.tripoin.core.dto.ResponseData;

import java.io.Serializable;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ADDRESS>
 * @param <CONTACT>
 */
public class ProfileResponseDTO<ADDRESS, CONTACT> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4419407064986008496L;

	private Long id;
	private String username;
	private String name;
	private Integer gender;
	private String birthdate;
	private ADDRESS address;
	private CONTACT contact;
	private String photo;
	private RoleResponseDTO authority;
	private I18NLocaleResponseDTO locale;
	private ResponseData responseData;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResponseData getResponseData() {
		return responseData;
	}

	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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
	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public ADDRESS getAddress() {
		return address;
	}

	public void setAddress(ADDRESS address) {
		this.address = address;
	}

	public CONTACT getContact() {
		return contact;
	}

	public void setContact(CONTACT contact) {
		this.contact = contact;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public RoleResponseDTO getAuthority() {
		return authority;
	}

	public void setAuthority(RoleResponseDTO authority) {
		this.authority = authority;
	}

	public I18NLocaleResponseDTO getLocale() {
		return locale;
	}

	public void setLocale(I18NLocaleResponseDTO locale) {
		this.locale = locale;
	}

}
