/**
 * 
 */
package com.ldd.bdd.repository;

import com.ldd.bdd.DTO.Request.ProductInventoryDTORequest;

/**
 * @author Diego
 *
 */

public interface ProductInventoryRepository{
	public int updateQuatity(ProductInventoryDTORequest productInventoryDTORequest);
}
