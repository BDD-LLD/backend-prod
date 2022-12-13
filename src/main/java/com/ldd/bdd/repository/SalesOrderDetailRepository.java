/**
 * 
 */
package com.ldd.bdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ldd.bdd.entity.SalesOrderDetail;

/**
 * @author Diego
 *
 */
@Repository
public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, Integer>{

	/**
	 * @param qty
	 * @param soID
	 * @return
	 */
	@Query(value = "UPDATE salesaw.Sales.SalesOrderDetail set orderQty = ?1 WHERE salesOrderID = ?2\r\n"
			+ "",nativeQuery=true)
	Object orderQtyUpdate(int qty, int soID);

}
