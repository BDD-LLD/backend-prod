/**
 * 
 */
package com.ldd.bdd.repository;

import com.ldd.bdd.entity.ProductInventory;
import org.springframework.data.jpa.repository.Query;
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
@Repository
public interface ProductInventoryRepository extends CrudRepository<ProductInventory,Integer>{
	
	//int updateQuatity(ProductInventoryDTORequest productInventoryDTORequest);

	@Query(value = "Call sp_updateQuantity  :p_location, :p_category ",nativeQuery = true)
	int updateQ(@Param("p_location") int p_location,@Param("p_category") int p_category);
	  
	
}
