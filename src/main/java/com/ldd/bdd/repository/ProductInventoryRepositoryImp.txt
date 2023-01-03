package com.ldd.bdd.repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.ldd.bdd.DTO.Request.ProductInventoryDTORequest;


@Repository
/*@NamedStoredProcedureQuery(
        name = "sp_updateQuantity",
        procedureName = "sp_updateQuantity",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "p_location"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "p_category")
        }
)*/

public class ProductInventoryRepositoryImp implements ProductInventoryRepository{

    private static Logger logger = LoggerFactory.getLogger(ProductInventoryRepositoryImp.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public int updateQuatity(ProductInventoryDTORequest productInventoryDTORequest) {
        
        StoredProcedureQuery query = this.em.createStoredProcedureQuery("sp_updateQuantity");
        query.registerStoredProcedureParameter("p_location",Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_category",Integer.class, ParameterMode.IN);
        query.setParameter("p_location",productInventoryDTORequest.getLocation());
        query.setParameter("p_category",productInventoryDTORequest.getCategory());
        query.execute();
        int bandera = (int)query.getSingleResult();
        return bandera;
    }
}
