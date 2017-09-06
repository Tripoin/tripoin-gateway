package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;
import java.util.List;

public class CreditCardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3085404816314740077L;
	
	private boolean save_card;
	private boolean secure;
	private String channel;
	private String bank;
	private InstallmentDTO installment;
	private List<Integer> whitelist_bins;
	
	public boolean isSave_card() {
		return save_card;
	}
	public void setSave_card(boolean save_card) {
		this.save_card = save_card;
	}
	public boolean isSecure() {
		return secure;
	}
	public void setSecure(boolean secure) {
		this.secure = secure;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public InstallmentDTO getInstallment() {
		return installment;
	}
	public void setInstallment(InstallmentDTO installment) {
		this.installment = installment;
	}
	public List<Integer> getWhitelist_bins() {
		return whitelist_bins;
	}
	public void setWhitelist_bins(List<Integer> whitelist_bins) {
		this.whitelist_bins = whitelist_bins;
	}
	
	
	
}
