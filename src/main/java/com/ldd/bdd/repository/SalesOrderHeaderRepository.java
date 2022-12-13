/**
 * 
 */
package com.ldd.bdd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ldd.bdd.DTO.TotalDeVentasDTO;
import com.ldd.bdd.entity.SalesOrderHeader;

/**
 * @author Diego
 *
 */
public interface SalesOrderHeaderRepository extends CrudRepository<SalesOrderHeader, Integer>{
	
	
	@Query(value = "SELECT soh.TerritoryID as id_Territorio, SUM(T.lineTotal) as total_Ventas\r\n"
			+ "FROM [salesaw].salesaw.Sales.SalesOrderHeader soh\r\n"
			+ "    inner join\r\n"
			+ "    ( SELECT SalesOrderID, productId, orderqty, lineTotal\r\n"
			+ "    FROM [salesaw].salesaw.Sales.SalesOrderDetail sod\r\n"
			+ "    WHERE ProductID in(\r\n"
			+ "    	SELECT productID\r\n"
			+ "    FROM productionaw.Production.Product\r\n"
			+ "    WHERE ProductSubcategoryID in(\r\n"
			+ "    		SELECT productSubcategoryId\r\n"
			+ "    FROM productionaw.Production.ProductSubcategory\r\n"
			+ "    WHERE ProductCategoryID in(\r\n"
			+ "    			SELECT productCategoryID\r\n"
			+ "    FROM productionaw.Production.ProductCategory\r\n"
			+ "    WHERE ProductCategoryID = :p_categoryID\r\n"
			+ "   				)\r\n"
			+ "   			)\r\n"
			+ ")) as T\r\n"
			+ "    on soh.SalesOrderID=T.SalesOrderID\r\n"
			+ "GROUP by soh.TerritoryId\r\n"
			+ "ORDER  by total_Ventas DESC\r\n"
			+ "",nativeQuery = true)
	List<Object[]> findTotalDeVentasDTO(int p_categoryID);

	/**
	 * @param p_SalesOrderID
	 * @param p_ShipMethodID
	 * @return
	 */
	@Modifying
	@Query(value = "UPDATE salesaw.Sales.SalesOrderHeader set ShipMethodID = :p_ShipMethodID WHERE SalesOrderID = :p_SalesOrderID"
			+ "",nativeQuery = true)
	Object updateShipMethodID(int p_SalesOrderID,int p_ShipMethodID);

}
