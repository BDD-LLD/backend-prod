/**
 * 
 */
package com.ldd.bdd.DTO;

import java.io.Serializable;

/**
 * @author Diego
 *
 */
public class UpdateQtyDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int productid;
	
	private int locationid;
	
	private int quantity;

	/**
	 * 
	 */
	public UpdateQtyDTO() {
	}

	/**
	 * @param productid
	 * @param locationid
	 * @param quantity
	 */
	public UpdateQtyDTO(int productid, int locationid, int quantity) {
		this.productid = productid;
		this.locationid = locationid;
		this.quantity = quantity;
	}

	/**
	 * @return the productid
	 */
	public int getProductid() {
		return productid;
	}

	/**
	 * @param productid the productid to set
	 */
	public void setProductid(int productid) {
		this.productid = productid;
	}

	/**
	 * @return the locationid
	 */
	public int getLocationid() {
		return locationid;
	}

	/**
	 * @param locationid the locationid to set
	 */
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "UpdateQtyDTO [productid=" + productid + ", locationid=" + locationid + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	

}
