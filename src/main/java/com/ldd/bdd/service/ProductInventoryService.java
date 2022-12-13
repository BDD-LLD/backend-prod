/**
 * 
 */
package com.ldd.bdd.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

/**
 * @author Diego
 *
 */
@Service
public class ProductInventoryService {
	 @PersistenceContext
	    EntityManager em;
	 
	 
	 public List<Object[]> updateqty(int p_localidad,int p_categoria){
	        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("UPDATEQTY");
	        spq.setParameter("P_LOCALIDAD",p_localidad);
	        spq.setParameter("P_CATEGORY",p_categoria);
	        spq.execute();
	        return spq.getResultList();
	    }

}
