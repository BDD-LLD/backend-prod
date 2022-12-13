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
import javax.persistence.CascadeType;
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
@Table(name = "SpecialOffer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecialOffer.findAll", query = "SELECT s FROM SpecialOffer s"),
    @NamedQuery(name = "SpecialOffer.findBySpecialOfferID", query = "SELECT s FROM SpecialOffer s WHERE s.specialOfferID = :specialOfferID"),
    @NamedQuery(name = "SpecialOffer.findByDescription", query = "SELECT s FROM SpecialOffer s WHERE s.description = :description"),
    @NamedQuery(name = "SpecialOffer.findByDiscountPct", query = "SELECT s FROM SpecialOffer s WHERE s.discountPct = :discountPct"),
    @NamedQuery(name = "SpecialOffer.findByType", query = "SELECT s FROM SpecialOffer s WHERE s.type = :type"),
    @NamedQuery(name = "SpecialOffer.findByCategory", query = "SELECT s FROM SpecialOffer s WHERE s.category = :category"),
    @NamedQuery(name = "SpecialOffer.findByStartDate", query = "SELECT s FROM SpecialOffer s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SpecialOffer.findByEndDate", query = "SELECT s FROM SpecialOffer s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SpecialOffer.findByMinQty", query = "SELECT s FROM SpecialOffer s WHERE s.minQty = :minQty"),
    @NamedQuery(name = "SpecialOffer.findByMaxQty", query = "SELECT s FROM SpecialOffer s WHERE s.maxQty = :maxQty"),
    @NamedQuery(name = "SpecialOffer.findByRowguid", query = "SELECT s FROM SpecialOffer s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SpecialOffer.findByModifiedDate", query = "SELECT s FROM SpecialOffer s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpecialOfferID")
    private Integer specialOfferID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "DiscountPct")
    private BigDecimal discountPct;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;
    @Basic(optional = false)
    @Column(name = "Category")
    private String category;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "MinQty")
    private int minQty;
    @Column(name = "MaxQty")
    private Integer maxQty;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOffer")
    private List<SpecialOfferProduct> specialOfferProductList;

    public SpecialOffer() {
    }

    public SpecialOffer(Integer specialOfferID) {
        this.specialOfferID = specialOfferID;
    }

    public SpecialOffer(Integer specialOfferID, String description, BigDecimal discountPct, String type, String category, Date startDate, Date endDate, int minQty, String rowguid, Date modifiedDate) {
        this.specialOfferID = specialOfferID;
        this.description = description;
        this.discountPct = discountPct;
        this.type = type;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minQty = minQty;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getSpecialOfferID() {
        return specialOfferID;
    }

    public void setSpecialOfferID(Integer specialOfferID) {
        this.specialOfferID = specialOfferID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountPct() {
        return discountPct;
    }

    public void setDiscountPct(BigDecimal discountPct) {
        this.discountPct = discountPct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }

    public Integer getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(Integer maxQty) {
        this.maxQty = maxQty;
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
    public List<SpecialOfferProduct> getSpecialOfferProductList() {
        return specialOfferProductList;
    }

    public void setSpecialOfferProductList(List<SpecialOfferProduct> specialOfferProductList) {
        this.specialOfferProductList = specialOfferProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialOfferID != null ? specialOfferID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialOffer)) {
            return false;
        }
        SpecialOffer other = (SpecialOffer) object;
        if ((this.specialOfferID == null && other.specialOfferID != null) || (this.specialOfferID != null && !this.specialOfferID.equals(other.specialOfferID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.SpecialOffer[ specialOfferID=" + specialOfferID + " ]";
    }
    
}
