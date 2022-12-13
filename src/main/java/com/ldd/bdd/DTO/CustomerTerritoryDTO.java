/**
 * 
 */
package com.ldd.bdd.DTO;

import java.io.Serializable;

/**
 * @author Diego
 *
 */
public class CustomerTerritoryDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String territorio_cliente;
	
	private String territorio_orden;

	/**
	 * 
	 */
	public CustomerTerritoryDTO() {
	}

	/**
	 * @param territorio_cliente
	 * @param territorio_orden
	 */
	public CustomerTerritoryDTO(String territorio_cliente, String territorio_orden) {
		this.territorio_cliente = territorio_cliente;
		this.territorio_orden = territorio_orden;
	}

	/**
	 * @return the territorio_cliente
	 */
	public String getTerritorio_cliente() {
		return territorio_cliente;
	}

	/**
	 * @param territorio_cliente the territorio_cliente to set
	 */
	public void setTerritorio_cliente(String territorio_cliente) {
		this.territorio_cliente = territorio_cliente;
	}

	/**
	 * @return the territorio_orden
	 */
	public String getTerritorio_orden() {
		return territorio_orden;
	}

	/**
	 * @param territorio_orden the territorio_orden to set
	 */
	public void setTerritorio_orden(String territorio_orden) {
		this.territorio_orden = territorio_orden;
	}

	@Override
	public String toString() {
		return "CustomerTerritoryDTO [territorio_cliente=" + territorio_cliente + ", territorio_orden="
				+ territorio_orden + "]";
	}
	
	
	
	
	
	

}
