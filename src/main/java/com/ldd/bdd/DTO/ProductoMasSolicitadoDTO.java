/**
 * 
 */
package com.ldd.bdd.DTO;

import java.io.Serializable;

/**
 * @author Diego
 *
 */
public class ProductoMasSolicitadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double total_ventas;
	
	private String nombre;
	
	private Integer id_producto;

	
	
	/**
	 * @param total_ventas
	 * @param nombre
	 * @param id_producto
	 */
	public ProductoMasSolicitadoDTO(Double total_ventas, String nombre, Integer id_producto) {
		this.total_ventas = total_ventas;
		this.nombre = nombre;
		this.id_producto = id_producto;
	}

	/**
	 * 
	 */
	public ProductoMasSolicitadoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the total_ventas
	 */
	public Double getTotal_ventas() {
		return total_ventas;
	}

	/**
	 * @param total_ventas the total_ventas to set
	 */
	public void setTotal_ventas(Double total_ventas) {
		this.total_ventas = total_ventas;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id_producto
	 */
	public Integer getId_producto() {
		return id_producto;
	}

	/**
	 * @param id_producto the id_producto to set
	 */
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductoMasSolicitadoDTO [total_ventas=" + total_ventas + ", nombre=" + nombre + ", id_producto="
				+ id_producto + "]";
	}
	
	
	
	
	

}
