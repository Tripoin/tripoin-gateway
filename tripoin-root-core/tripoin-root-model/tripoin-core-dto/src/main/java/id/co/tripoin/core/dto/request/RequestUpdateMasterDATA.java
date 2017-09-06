package id.co.tripoin.core.dto.request;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 *  <p>
 *  	{@link DATA} should be include with ID
 *  </p>
 */
public class RequestUpdateMasterDATA<DATA> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6712287619807751848L;
	private ArrayList<DATA> datas;

	@JsonProperty("datas")
	public ArrayList<DATA> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<DATA> datas) {
		this.datas = datas;
	}
	
	

}
