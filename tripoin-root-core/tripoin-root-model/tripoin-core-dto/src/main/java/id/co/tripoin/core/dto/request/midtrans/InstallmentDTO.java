package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;

public class InstallmentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3415170900565359809L;
	private boolean required;
	private TermsDTO terms;
	
	public boolean isRequire() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public TermsDTO getTerms() {
		return terms;
	}
	public void setTerms(TermsDTO terms) {
		this.terms = terms;
	}
	
	
}
