package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;

public class CustomerDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5902141857553356072L;

	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private CustomerAddressDTO billing_address;
	private CustomerAddressDTO shipping_address;
		
	public CustomerAddressDTO getBilling_address() {
		return billing_address;
	}
	public void setBilling_address(CustomerAddressDTO billing_address) {
		this.billing_address = billing_address;
	}
	public CustomerAddressDTO getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(CustomerAddressDTO shipping_address) {
		this.shipping_address = shipping_address;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
