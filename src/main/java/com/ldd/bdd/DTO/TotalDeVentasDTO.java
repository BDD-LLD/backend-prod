/**
 * 
 */
package com.ldd.bdd.DTO;

import java.io.Serializable;

/**
 * @author Diego
 *
 */
public class TotalDeVentasDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_Territorio;
	
	private Float total_Ventas;

	/**
	 * 
	 */
	public TotalDeVentasDTO() {
	}

	/**
	 * @return the id_Territorio
	 */
	public Integer getId_Territorio() {
		return id_Territorio;
	}

	/**
	 * @param id_Territorio the id_Territorio to set
	 */
	public void setId_Territorio(Integer id_Territorio) {
		this.id_Territorio = id_Territorio;
	}

	/**
	 * @return the total_Ventas
	 */
	public Float getTotal_Ventas() {
		return total_Ventas;
	}

	/**
	 * @param total_Ventas the total_Ventas to set
	 */
	public void setTotal_Ventas(Float total_Ventas) {
		this.total_Ventas = total_Ventas;
	}

	@Override
	public String toString() {
		return "\n[id_Territorio=" + id_Territorio + ", total_Ventas=" + total_Ventas +"]";
	}
	
	
	

}
