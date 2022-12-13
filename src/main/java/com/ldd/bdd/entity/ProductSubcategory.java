/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ProductSubcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSubcategory.findAll", query = "SELECT p FROM ProductSubcategory p"),
    @NamedQuery(name = "ProductSubcategory.findByProductSubcategoryID", query = "SELECT p FROM ProductSubcategory p WHERE p.productSubcategoryID = :productSubcategoryID"),
    @NamedQuery(name = "ProductSubcategory.findByName", query = "SELECT p FROM ProductSubcategory p WHERE p.name = :name"),
    @NamedQuery(name = "ProductSubcategory.findByRowguid", query = "SELECT p FROM ProductSubcategory p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductSubcategory.findByModifiedDate", query = "SELECT p FROM ProductSubcategory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductSubcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductSubcategoryID")
    private Integer productSubcategoryID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "productSubcategoryID")
    private List<Product> productList;
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID")
    @ManyToOne(optional = false)
    private ProductCategory productCategoryID;

    public ProductSubcategory() {
    }

    public ProductSubcategory(Integer productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
    }

    public ProductSubcategory(Integer productSubcategoryID, String name, String rowguid, Date modifiedDate) {
        this.productSubcategoryID = productSubcategoryID;
        this.name = name;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductSubcategoryID() {
        return productSubcategoryID;
    }

    public void setProductSubcategoryID(Integer productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductCategory getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(ProductCategory productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSubcategoryID != null ? productSubcategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSubcategory)) {
            return false;
        }
        ProductSubcategory other = (ProductSubcategory) object;
        if ((this.productSubcategoryID == null && other.productSubcategoryID != null) || (this.productSubcategoryID != null && !this.productSubcategoryID.equals(other.productSubcategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.ProductSubcategory[ productSubcategoryID=" + productSubcategoryID + " ]";
    }
    
}
