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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SalesPerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesPerson.findAll", query = "SELECT s FROM SalesPerson s"),
    @NamedQuery(name = "SalesPerson.findByBusinessEntityID", query = "SELECT s FROM SalesPerson s WHERE s.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "SalesPerson.findBySalesQuota", query = "SELECT s FROM SalesPerson s WHERE s.salesQuota = :salesQuota"),
    @NamedQuery(name = "SalesPerson.findByBonus", query = "SELECT s FROM SalesPerson s WHERE s.bonus = :bonus"),
    @NamedQuery(name = "SalesPerson.findByCommissionPct", query = "SELECT s FROM SalesPerson s WHERE s.commissionPct = :commissionPct"),
    @NamedQuery(name = "SalesPerson.findBySalesYTD", query = "SELECT s FROM SalesPerson s WHERE s.salesYTD = :salesYTD"),
    @NamedQuery(name = "SalesPerson.findBySalesLastYear", query = "SELECT s FROM SalesPerson s WHERE s.salesLastYear = :salesLastYear"),
    @NamedQuery(name = "SalesPerson.findByRowguid", query = "SELECT s FROM SalesPerson s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesPerson.findByModifiedDate", query = "SELECT s FROM SalesPerson s WHERE s.modifiedDate = :modifiedDate")})
public class SalesPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
    @Basic(optional = false)
    @Column(name = "Bonus")
    private BigDecimal bonus;
    @Basic(optional = false)
    @Column(name = "CommissionPct")
    private BigDecimal commissionPct;
    @Basic(optional = false)
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
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
    @OneToMany(mappedBy = "salesPersonID")
    private List<SalesOrderHeader> salesOrderHeaderList;
    @OneToMany(mappedBy = "salesPersonID")
    private List<Store> storeList;

    public SalesPerson() {
    }

    public SalesPerson(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public SalesPerson(Integer businessEntityID, BigDecimal bonus, BigDecimal commissionPct, BigDecimal salesYTD, BigDecimal salesLastYear, String rowguid, Date modifiedDate) {
        this.businessEntityID = businessEntityID;
        this.bonus = bonus;
        this.commissionPct = commissionPct;
        this.salesYTD = salesYTD;
        this.salesLastYear = salesLastYear;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public BigDecimal getSalesQuota() {
        return salesQuota;
    }

    public void setSalesQuota(BigDecimal salesQuota) {
        this.salesQuota = salesQuota;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
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

    @XmlTransient
    public List<SalesOrderHeader> getSalesOrderHeaderList() {
        return salesOrderHeaderList;
    }

    public void setSalesOrderHeaderList(List<SalesOrderHeader> salesOrderHeaderList) {
        this.salesOrderHeaderList = salesOrderHeaderList;
    }

    @XmlTransient
    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessEntityID != null ? businessEntityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesPerson)) {
            return false;
        }
        SalesPerson other = (SalesPerson) object;
        if ((this.businessEntityID == null && other.businessEntityID != null) || (this.businessEntityID != null && !this.businessEntityID.equals(other.businessEntityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.SalesPerson[ businessEntityID=" + businessEntityID + " ]";
    }
    
}
