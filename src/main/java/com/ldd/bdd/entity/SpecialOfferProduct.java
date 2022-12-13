/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SpecialOfferProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecialOfferProduct.findAll", query = "SELECT s FROM SpecialOfferProduct s"),
    @NamedQuery(name = "SpecialOfferProduct.findBySpecialOfferID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.specialOfferID = :specialOfferID"),
    @NamedQuery(name = "SpecialOfferProduct.findByProductID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.productID = :productID"),
    @NamedQuery(name = "SpecialOfferProduct.findByRowguid", query = "SELECT s FROM SpecialOfferProduct s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SpecialOfferProduct.findByModifiedDate", query = "SELECT s FROM SpecialOfferProduct s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOfferProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecialOfferProductPK specialOfferProductPK;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SpecialOffer specialOffer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOfferProduct")
    private List<SalesOrderDetail> salesOrderDetailList;

    public SpecialOfferProduct() {
    }

    public SpecialOfferProduct(SpecialOfferProductPK specialOfferProductPK) {
        this.specialOfferProductPK = specialOfferProductPK;
    }

    public SpecialOfferProduct(SpecialOfferProductPK specialOfferProductPK, String rowguid, Date modifiedDate) {
        this.specialOfferProductPK = specialOfferProductPK;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public SpecialOfferProduct(int specialOfferID, int productID) {
        this.specialOfferProductPK = new SpecialOfferProductPK(specialOfferID, productID);
    }

    public SpecialOfferProductPK getSpecialOfferProductPK() {
        return specialOfferProductPK;
    }

    public void setSpecialOfferProductPK(SpecialOfferProductPK specialOfferProductPK) {
        this.specialOfferProductPK = specialOfferProductPK;
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

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }

    @XmlTransient
    public List<SalesOrderDetail> getSalesOrderDetailList() {
        return salesOrderDetailList;
    }

    public void setSalesOrderDetailList(List<SalesOrderDetail> salesOrderDetailList) {
        this.salesOrderDetailList = salesOrderDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialOfferProductPK != null ? specialOfferProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialOfferProduct)) {
            return false;
        }
        SpecialOfferProduct other = (SpecialOfferProduct) object;
        if ((this.specialOfferProductPK == null && other.specialOfferProductPK != null) || (this.specialOfferProductPK != null && !this.specialOfferProductPK.equals(other.specialOfferProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.SpecialOfferProduct[ specialOfferProductPK=" + specialOfferProductPK + " ]";
    }
    
}
