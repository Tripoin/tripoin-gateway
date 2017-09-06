package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;
import java.util.List;

public class RequestMIDTRANSCompleteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -896638475425835399L;
	private String user_id;
	private RequestContentMIDTRANSSimpleDTO transaction_details;
	private List<String> enabled_payments;
	private CreditCardDTO credit_card;
	private List<ItemDetailsDTO> item_details;
	private CustomerDetailsDTO customer_details;
	private ExpiryDTO expiry;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public RequestContentMIDTRANSSimpleDTO getTransaction_details() {
		return transaction_details;
	}
	public void setTransaction_details(RequestContentMIDTRANSSimpleDTO transaction_details) {
		this.transaction_details = transaction_details;
	}
	public List<String> getEnabled_payments() {
		return enabled_payments;
	}
	public void setEnabled_payments(List<String> enabled_payments) {
		this.enabled_payments = enabled_payments;
	}
	public CreditCardDTO getCredit_card() {
		return credit_card;
	}
	public void setCredit_card(CreditCardDTO credit_card) {
		this.credit_card = credit_card;
	}
	public List<ItemDetailsDTO> getItem_details() {
		return item_details;
	}
	public void setItem_details(List<ItemDetailsDTO> item_details) {
		this.item_details = item_details;
	}
	public CustomerDetailsDTO getCustomer_details() {
		return customer_details;
	}
	public void setCustomer_details(CustomerDetailsDTO customer_details) {
		this.customer_details = customer_details;
	}
	public ExpiryDTO getExpiry() {
		return expiry;
	}
	public void setExpiry(ExpiryDTO expiry) {
		this.expiry = expiry;
	}
	
	
}
