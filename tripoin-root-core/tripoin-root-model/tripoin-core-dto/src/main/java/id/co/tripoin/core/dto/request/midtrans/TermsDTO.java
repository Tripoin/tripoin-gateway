package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;
import java.util.List;

public class TermsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4658531984549947295L;
	private List<Integer> bni;
	private List<Integer> mandiri;
	private List<Integer> cimb;
	private List<Integer> bca;
	private List<Integer> offline;
	
	public List<Integer> getBni() {
		return bni;
	}
	public void setBni(List<Integer> bni) {
		this.bni = bni;
	}
	public List<Integer> getMandiri() {
		return mandiri;
	}
	public void setMandiri(List<Integer> mandiri) {
		this.mandiri = mandiri;
	}
	public List<Integer> getCimb() {
		return cimb;
	}
	public void setCimb(List<Integer> cimb) {
		this.cimb = cimb;
	}
	public List<Integer> getBca() {
		return bca;
	}
	public void setBca(List<Integer> bca) {
		this.bca = bca;
	}
	public List<Integer> getOffline() {
		return offline;
	}
	public void setOffline(List<Integer> offline) {
		this.offline = offline;
	}
	@Override
	public String toString() {
		return "TermsDTO [bni=" + bni + ", mandiri=" + mandiri + ", cimb=" + cimb + ", bca=" + bca + ", offline="
				+ offline + "]";
	}
	
	
}
