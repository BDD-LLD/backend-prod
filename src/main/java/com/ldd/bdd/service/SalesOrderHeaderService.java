/**
 * 
 */
package com.ldd.bdd.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ldd.bdd.repository.SalesOrderHeaderRepository;

/**
 * @author Diego
 *
 */
public class SalesOrderHeaderService {
	
	@Autowired
	private SalesOrderHeaderRepository salesOrderHeaderRepository;

	/**
	 * @param p_ShipMethodID
	 * @param p_SalesOrderID
	 * @return
	 */
	public Object updateShipMethodID(int p_ShipMethodID,int p_SalesOrderID) {
    	return salesOrderHeaderRepository.updateShipMethodID(p_SalesOrderID, p_ShipMethodID);
    }

}
