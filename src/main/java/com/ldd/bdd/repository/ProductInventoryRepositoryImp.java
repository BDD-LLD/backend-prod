package com.ldd.bdd.repository;

import com.ldd.bdd.DTO.Request.ProductInventoryDTORequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.Parameter;

public class ProductInventoryRepositoryImp implements ProductInventoryRepository{

    private static Logger logger = LoggerFactory.getLogger(ProductInventoryRepositoryImp.class);

    private final static String USERS_PROC = ".INSERT_JP_USERS";

    @Autowired
    private EntityManager entityManager;

    @Override
    public void updateQuatity(ProductInventoryDTORequest productInventoryDTORequest) {
        StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("sp_updateQuantity");
        query.registerStoredProcedureParameter("p_location",Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_category",Integer.class, ParameterMode.IN);
        query.setParameter("p_location",productInventoryDTORequest.getLocation());
        query.setParameter("p_category",productInventoryDTORequest.getCategory());
        int bandera = (int)query.getSingleResult();
        logger.info("Bandera: "+bandera);
    }
}
