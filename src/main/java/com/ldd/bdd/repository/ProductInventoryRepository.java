/**
 * 
 */
package com.ldd.bdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ldd.bdd.entity.ProductInventory;

/**
 * @author Diego
 *
 */
@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Integer> {
	
}
