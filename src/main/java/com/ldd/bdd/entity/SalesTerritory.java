/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "SalesTerritory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesTerritory.findAll", query = "SELECT s FROM SalesTerritory s"),
    @NamedQuery(name = "SalesTerritory.findByTerritoryID", query = "SELECT s FROM SalesTerritory s WHERE s.territoryID = :territoryID"),
    @NamedQuery(name = "SalesTerritory.findByName", query = "SELECT s FROM SalesTerritory s WHERE s.name = :name"),
    @NamedQuery(name = "SalesTerritory.findByCountryRegionCode", query = "SELECT s FROM SalesTerritory s WHERE s.countryRegionCode = :countryRegionCode"),
    @NamedQuery(name = "SalesTerritory.findByGroup", query = "SELECT s FROM SalesTerritory s WHERE s.group = :group"),
    @NamedQuery(name = "SalesTerritory.findBySalesYTD", query = "SELECT s FROM SalesTerritory s WHERE s.salesYTD = :salesYTD"),
    @NamedQuery(name = "SalesTerritory.findBySalesLastYear", query = "SELECT s FROM SalesTerritory s WHERE s.salesLastYear = :salesLastYear"),
    @NamedQuery(name = "SalesTerritory.findByCostYTD", query = "SELECT s FROM SalesTerritory s WHERE s.costYTD = :costYTD"),
    @NamedQuery(name = "SalesTerritory.findByCostLastYear", query = "SELECT s FROM SalesTerritory s WHERE s.costLastYear = :costLastYear"),
    @NamedQuery(name = "SalesTerritory.findByRowguid", query = "SELECT s FROM SalesTerritory s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesTerritory.findByModifiedDate", query = "SELECT s FROM SalesTerritory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTerritory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TerritoryID")
    private Integer territoryID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Basic(optional = false)
    @Column(name = "Group")
    private String group;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
    @Basic(optional = false)
    @Column(name = "CostYTD")
    private BigDecimal costYTD;
    @Basic(optional = false)
    @Column(name = "CostLastYear")
    private BigDecimal costLastYear;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "territoryID")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "territoryID")
    private List<SalesPerson> salesPersonList;
    @OneToMany(mappedBy = "territoryID")
    private List<SalesOrderHeader> salesOrderHeaderList;

    public SalesTerritory() {
    }

    public SalesTerritory(Integer territoryID) {
        this.territoryID = territoryID;
    }

    public SalesTerritory(Integer territoryID, String name, String countryRegionCode, String group, BigDecimal salesYTD, BigDecimal salesLastYear, BigDecimal costYTD, BigDecimal costLastYear, String rowguid, Date modifiedDate) {
        this.territoryID = territoryID;
        this.name = name;
        this.countryRegionCode = countryRegionCode;
        this.group = group;
        this.salesYTD = salesYTD;
        this.salesLastYear = salesLastYear;
        this.costYTD = costYTD;
        this.costLastYear = costLastYear;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(Integer territoryID) {
        this.territoryID = territoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryRegionCode() {
        return countryRegionCode;
    }

    public void setCountryRegionCode(String countryRegionCode) {
        this.countryRegionCode = countryRegionCode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public BigDecimal getSalesYTD() {
        return salesYTD;
    }

    public void setSalesYTD(BigDecimal salesYTD) {
        this.salesYTD = salesYTD;
    }

    public BigDecimal getSalesLastYear() {
        return salesLastYear;
    }

    public void setSalesLastYear(BigDecimal salesLastYear) {
        this.salesLastYear = salesLastYear;
    }

    public BigDecimal getCostYTD() {
        return costYTD;
    }

    public void setCostYTD(BigDecimal costYTD) {
        this.costYTD = costYTD;
    }

    public BigDecimal getCostLastYear() {
        return costLastYear;
    }

    public void setCostLastYear(BigDecimal costLastYear) {
        this.costLastYear = costLastYear;
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

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<SalesPerson> getSalesPersonList() {
        return salesPersonList;
    }

    public void setSalesPersonList(List<SalesPerson> salesPersonList) {
        this.salesPersonList = salesPersonList;
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
        hash += (territoryID != null ? territoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesTerritory)) {
            return false;
        }
        SalesTerritory other = (SalesTerritory) object;
        if ((this.territoryID == null && other.territoryID != null) || (this.territoryID != null && !this.territoryID.equals(other.territoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.SalesTerritory[ territoryID=" + territoryID + " ]";
    }
    
}
