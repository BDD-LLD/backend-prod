/**
 * 
 */
package com.ldd.bdd.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ldd.bdd.DTO.Request.ProductInventoryDTORequest;
import com.ldd.bdd.entity.ProductCategory;

/**
 * @author Diego
 *
 */

public interface ProductInventoryRepository {
	
	int updateQuatity(ProductInventoryDTORequest productInventoryDTORequest);
	  
	
}
