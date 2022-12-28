package com.ldd.bdd.repository;

import com.ldd.bdd.DTO.Request.ProductInventoryDTORequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.lang.reflect.Parameter;
@Repository

public class ProductInventoryRepositoryImp implements ProductInventoryRepository{

    private static Logger logger = LoggerFactory.getLogger(ProductInventoryRepositoryImp.class);

    @Autowired
    private EntityManager em;

    @Override
    public int updateQuatity(ProductInventoryDTORequest productInventoryDTORequest) {
        logger.info(String.valueOf(productInventoryDTORequest.getLocation()));
        StoredProcedureQuery query = this.em.createStoredProcedureQuery("sp_updateQuantity");
        query.registerStoredProcedureParameter("p_location",Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_category",Integer.class, ParameterMode.IN);
        query.setParameter("p_location",productInventoryDTORequest.getLocation());
        query.setParameter("p_category",productInventoryDTORequest.getCategory());
        query.execute();
        int bandera = (int)query.getSingleResult();
        logger.info("Bandera: "+bandera);
        return bandera;
    }
}
