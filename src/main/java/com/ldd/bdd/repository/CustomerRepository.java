/**
 * 
 */
package com.ldd.bdd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ldd.bdd.DTO.CustomerTerritoryDTO;
import com.ldd.bdd.entity.Customer;

/**
 * @author Diego
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	@Query(name = "getCustomerDiferrentTerritory",nativeQuery = true)
	List<CustomerTerritoryDTO[]> getCustomerDiferrentTerritory();

}
