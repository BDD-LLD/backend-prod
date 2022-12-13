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
@Table(name = "ProductModel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModel.findAll", query = "SELECT p FROM ProductModel p"),
    @NamedQuery(name = "ProductModel.findByProductModelID", query = "SELECT p FROM ProductModel p WHERE p.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModel.findByName", query = "SELECT p FROM ProductModel p WHERE p.name = :name"),
    @NamedQuery(name = "ProductModel.findByCatalogDescription", query = "SELECT p FROM ProductModel p WHERE p.catalogDescription = :catalogDescription"),
    @NamedQuery(name = "ProductModel.findByInstructions", query = "SELECT p FROM ProductModel p WHERE p.instructions = :instructions"),
    @NamedQuery(name = "ProductModel.findByRowguid", query = "SELECT p FROM ProductModel p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductModel.findByModifiedDate", query = "SELECT p FROM ProductModel p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductModelID")
    private Integer productModelID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "CatalogDescription")
    private String catalogDescription;
    @Column(name = "Instructions")
    private String instructions;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "productModelID")
    private List<Product> productList;

    public ProductModel() {
    }

    public ProductModel(Integer productModelID) {
        this.productModelID = productModelID;
    }

    public ProductModel(Integer productModelID, String name, String rowguid, Date modifiedDate) {
        this.productModelID = productModelID;
        this.name = name;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(Integer productModelID) {
        this.productModelID = productModelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productModelID != null ? productModelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModel)) {
            return false;
        }
        ProductModel other = (ProductModel) object;
        if ((this.productModelID == null && other.productModelID != null) || (this.productModelID != null && !this.productModelID.equals(other.productModelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.ProductModel[ productModelID=" + productModelID + " ]";
    }
    
}
