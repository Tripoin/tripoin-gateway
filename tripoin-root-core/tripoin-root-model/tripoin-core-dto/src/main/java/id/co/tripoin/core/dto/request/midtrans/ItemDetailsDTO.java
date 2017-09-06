package id.co.tripoin.core.dto.request.midtrans;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2452498237684108308L;

	private String id;
	private BigDecimal price;
	private Integer quantity;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
