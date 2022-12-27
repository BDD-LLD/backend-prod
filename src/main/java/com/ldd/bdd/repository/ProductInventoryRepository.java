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
	public void updateQuatity(ProductInventoryDTORequest productInventoryDTORequest);
}
