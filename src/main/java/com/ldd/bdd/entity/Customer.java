/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.ldd.bdd.DTO.CustomerTerritoryDTO;
import com.ldd.bdd.DTO.ProductoMasSolicitadoDTO;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "Customer")
@NamedNativeQuery(name = "getCustomerDiferrentTerritory", query = "SELECT\r\n"
		+ "	c.TerritoryID as territorio_cliente,\r\n" + "	soh.TerritoryID as territorio_orden\r\n" + "FROM\r\n"
		+ "	[salesaw].salesaw.Sales.Customer c\r\n" + "inner join \r\n"
		+ "	[salesaw].salesaw.Sales.SalesOrderHeader soh \r\n" + "	on\r\n"
		+ "	c.TerritoryID != soh.TerritoryID and c.CustomerID = soh.CustomerID \r\n" + "GROUP by\r\n"
		+ "	c.TerritoryID,\r\n" + "	soh.TerritoryID " + "", resultSetMapping = "CustomerTerritoryDTO")

@SqlResultSetMappings({ @SqlResultSetMapping(name = "CustomerTerritoryDTO", classes = {
		@ConstructorResult(targetClass = CustomerTerritoryDTO.class, columns = {
				@ColumnResult(name = "territorio_cliente", type = String.class),
				@ColumnResult(name = "territorio_orden", type = String.class) }) }) })
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CustomerID")
	private Integer customerID;
	@Column(name = "PersonID")
	private Integer personID;
	@Basic(optional = false)
	@Column(name = "AccountNumber")
	private String accountNumber;
	@Basic(optional = false)
	@Column(name = "rowguid")
	private String rowguid;
	@Basic(optional = false)
	@Column(name = "ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
	@ManyToOne
	private SalesTerritory territoryID;
	@JoinColumn(name = "StoreID", referencedColumnName = "BusinessEntityID")
	@ManyToOne
	private Store storeID;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
	private List<SalesOrderHeader> salesOrderHeaderList;

	public Customer() {
	}

	public Customer(Integer customerID) {
		this.customerID = customerID;
	}

	public Customer(Integer customerID, String accountNumber, String rowguid, Date modifiedDate) {
		this.customerID = customerID;
		this.accountNumber = accountNumber;
		this.rowguid = rowguid;
		this.modifiedDate = modifiedDate;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getPersonID() {
		return personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRowguid() {
		return rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public SalesTerritory getTerritoryID() {
		return territoryID;
	}

	public void setTerritoryID(SalesTerritory territoryID) {
		this.territoryID = territoryID;
	}

	public Store getStoreID() {
		return storeID;
	}

	public void setStoreID(Store storeID) {
		this.storeID = storeID;
	}

	@XmlTransient
	public List<SalesOrderHeader> getSalesOrderHeaderList() {
		return salesOrderHeaderList;
	}

	public void setSalesOrderHeaderList(List<SalesOrderHeader> salesOrderHeaderList) {
		this.salesOrderHeaderList = salesOrderHeaderList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (customerID != null ? customerID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) object;
		if ((this.customerID == null && other.customerID != null)
				|| (this.customerID != null && !this.customerID.equals(other.customerID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject1.Customer[ customerID=" + customerID + " ]";
	}

}
