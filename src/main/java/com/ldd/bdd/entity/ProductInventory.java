/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ldd.bdd.DTO.UpdateQtyDTO;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "ProductInventory")
@XmlRootElement
public class ProductInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductInventoryPK productInventoryPK;
    @Basic(optional = false)
    @Column(name = "Shelf")
    private String shelf;
    @Basic(optional = false)
    @Column(name = "Bin")
    private short bin;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private short quantity;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductInventory() {
    }

    public ProductInventory(ProductInventoryPK productInventoryPK) {
        this.productInventoryPK = productInventoryPK;
    }

    public ProductInventory(ProductInventoryPK productInventoryPK, String shelf, short bin, short quantity, String rowguid, Date modifiedDate) {
        this.productInventoryPK = productInventoryPK;
        this.shelf = shelf;
        this.bin = bin;
        this.quantity = quantity;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public ProductInventory(int productID, short locationID) {
        this.productInventoryPK = new ProductInventoryPK(productID, locationID);
    }

    public ProductInventoryPK getProductInventoryPK() {
        return productInventoryPK;
    }

    public void setProductInventoryPK(ProductInventoryPK productInventoryPK) {
        this.productInventoryPK = productInventoryPK;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public short getBin() {
        return bin;
    }

    public void setBin(short bin) {
        this.bin = bin;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productInventoryPK != null ? productInventoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductInventory)) {
            return false;
        }
        ProductInventory other = (ProductInventory) object;
        if ((this.productInventoryPK == null && other.productInventoryPK != null) || (this.productInventoryPK != null && !this.productInventoryPK.equals(other.productInventoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.ProductInventory[ productInventoryPK=" + productInventoryPK + " ]";
    }
    
}
