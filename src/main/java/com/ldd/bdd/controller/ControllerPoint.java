/**
 * 
 */
package com.ldd.bdd.controller;

import java.util.ArrayList;
import java.util.List;

import com.ldd.bdd.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ldd.bdd.DTO.ProductoMasSolicitadoDTO;
import com.ldd.bdd.DTO.TotalDeVentasDTO;
import com.ldd.bdd.DTO.UpdateQtyDTO;
import com.ldd.bdd.DTO.Request.ProductInventoryDTORequest;
import com.ldd.bdd.service.PersonService;
import com.ldd.bdd.service.SalesOrderDetailService;
import com.ldd.bdd.service.SalesOrderHeaderService;

/**
 * @author Diego
 *
 */

@RestController
@RequestMapping("/ejercicios")
public class ControllerPoint extends CommonController{
	
	
	@Autowired
	private SalesOrderHeaderRepository salesOrderHeaderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private SalesOrderDetailService salesOrderDetailService;
	
	@Autowired
	private SalesOrderHeaderService salesOrderHeaderService;
	
	@Autowired 
	private PersonService personService;

	@Autowired
	private ProductInventoryRepositoryImp productInventoryRepositoryImp;
	
	/*@Autowired
	private ProductInventoryRepository productInventoryRepository;*/

	private static final Logger log = LoggerFactory.getLogger(ControllerPoint.class);

	@GetMapping("/ejercicio1/{p_Category}")
	public ResponseEntity<List<TotalDeVentasDTO>> ejercicio1(@PathVariable int p_Category){
		try {
			List<TotalDeVentasDTO> listTotalDeVentasDTOs = new ArrayList<TotalDeVentasDTO>();
			salesOrderHeaderRepository.findTotalDeVentasDTO(p_Category).
			forEach(r->{
				TotalDeVentasDTO totalDeVentasDTO = new TotalDeVentasDTO();
				totalDeVentasDTO.setId_Territorio(Integer.valueOf(r[0].toString()));
				totalDeVentasDTO.setTotal_Ventas(Float.valueOf(r[1].toString()));
				listTotalDeVentasDTOs.add(totalDeVentasDTO);
			});
			log.info(listTotalDeVentasDTOs.toString());
			return ResponseEntity.ok(listTotalDeVentasDTOs);
		}catch (Exception e){
			log.warn(e.getMessage());
			return ResponseEntity.ok(null);
		}
	}
	
	@GetMapping("/ejercicio2/{p_Group}")
	public ResponseEntity<ProductoMasSolicitadoDTO> ejercicio2(@PathVariable String p_Group){
		try {
			ProductoMasSolicitadoDTO productoMasSolicitadoDTO = productRepository.findProductMoreRequested(p_Group);
			log.info(productoMasSolicitadoDTO.toString());
			/*return  ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                    null,"Servicio ejecutado exitosamente" ,productoMasSolicitadoDTO));*/
			return ResponseEntity.ok(productoMasSolicitadoDTO);
		} catch (Exception e) {
			log.warn(e.getMessage());
			/*return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                    null,"Servicio ejecutado exitosamente" ,null));*/
			return ResponseEntity.ok(null);
		}
	}
	
	@RequestMapping(path = "/ejercicio3",method = RequestMethod.POST)
	public ResponseEntity<?> ejercicio3(@RequestBody ProductInventoryDTORequest productInventoryDTORequest){
		try {
			List<UpdateQtyDTO> updateQtyDTOs = new ArrayList<UpdateQtyDTO>();
			int location = productInventoryDTORequest.getLocation();
			int category = productInventoryDTORequest.getCategory();
			log.info(String.valueOf(location),String.valueOf(category));
			//productInventoryRepository.sp_updateQuantity(location,category);
			productInventoryRepositoryImp.updateQuatity(productInventoryDTORequest);
			//log.info(String.valueOf(bandera));
			/*return  ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                    null,"Servicio ejecutado exitosamente" ,productoMasSolicitadoDTO));*/
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			log.warn(e.getMessage());
			/*return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                    null,"Servicio ejecutado exitosamente" ,null));*/
			return ResponseEntity.ok(null);
		}
	}
	
	@RequestMapping(value = "/ejercicio4", method = RequestMethod.GET)
	public ResponseEntity<?> ejercicio4(){
		if(customerRepository.getCustomerDiferrentTerritory().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.OK, String.format("No hay elementos en la lista"));
		}
		try {
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/ejercicio5", method = RequestMethod.POST)
	public ResponseEntity<?> ejercicio5(@RequestBody ProductInventoryDTORequest productInventoryDTORequest){
		try {
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/ejercicio6/{p_ShipMethodID}/{p_SalesOrderID}", method = RequestMethod.PATCH)
	public ResponseEntity<?> ejercicio6(@PathVariable int p_ShipMethodID,@PathVariable int p_SalesOrderID){
		try {
			return ResponseEntity.ok(salesOrderHeaderService.updateShipMethodID(p_ShipMethodID,p_SalesOrderID));
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/ejercicio7/{p_EmailAddressNew}/{p_EmailAddressID}", method = RequestMethod.PATCH)
	public ResponseEntity<?> ejercicio7(@PathVariable String p_EmailAddressNew,@PathVariable int p_EmailAddressID){
		try {
			return ResponseEntity.ok(personService.updateEmailAddress(p_EmailAddressNew, p_EmailAddressID));
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}

}
