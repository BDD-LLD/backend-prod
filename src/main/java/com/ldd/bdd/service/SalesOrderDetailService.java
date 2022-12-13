/**
 * 
 */
package com.ldd.bdd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldd.bdd.entity.SalesOrderDetail;
import com.ldd.bdd.repository.SalesOrderDetailRepository;

/**
 * @author Diego
 *
 */
@Service
public class SalesOrderDetailService {

	@Autowired
	private SalesOrderDetailRepository salesOrderDetailRepository;

	public Optional<SalesOrderDetail> findSalesOrderDetailByID(int id) {
		return salesOrderDetailRepository.findById(id);
	}

	/**
	 * @param qty
	 * @param soID
	 * @return
	 */
	@Transactional
    public Object orderQtyUpdate(int qty,int soID) {
    	return salesOrderDetailRepository.orderQtyUpdate(qty,soID);
    }
	
}
