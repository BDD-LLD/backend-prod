/**
 * 
 */
package com.ldd.bdd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.expression.spel.ast.OpInc;

import com.ldd.bdd.DTO.ProductoMasSolicitadoDTO;
import com.ldd.bdd.DTO.TotalDeVentasDTO;
import com.ldd.bdd.entity.Product;

/**
 * @author Diego
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	/*@Query(value = "SELECT TOP 1 SUM(T.lineTotal) as total_ventas, p.Name as nombre, p.ProductID as id_producto\r\n"
			+ "FROM productionaw.Production.Product p \r\n"
			+ "	inner join(\r\n"
			+ "		SELECT ProductID, lineTotal\r\n"
			+ "		FROM [salesaw].salesaw.Sales.SalesOrderDetail sod \r\n"
			+ "		WHERE SalesOrderID in(\r\n"
			+ "			SELECT SalesOrderID\r\n"
			+ "			FROM [salesaw].salesaw.Sales.SalesOrderHeader soh \r\n"
			+ "			WHERE TerritoryID in(\r\n"
			+ "				SELECT TerritoryID \r\n"
			+ "				FROM [salesaw].salesaw.Sales.SalesTerritory st \r\n"
			+ "				WHERE [Group] = :p_Group\r\n"
			+ "			)\r\n"
			+ "		)\r\n"
			+ "	) as T\r\n"
			+ "	on p.ProductID = T.ProductID\r\n"
			+ "	GROUP BY p.Name, p.ProductID \r\n"
			+ "	ORDER  by total_ventas DESC "
			+ "",nativeQuery = true)*/
	@Query(name = "findProductMoreRequested",nativeQuery = true)
	ProductoMasSolicitadoDTO findProductMoreRequested(String p_Group);

}
