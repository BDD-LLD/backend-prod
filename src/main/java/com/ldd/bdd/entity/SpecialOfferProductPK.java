/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Diego
 */
@Embeddable
public class SpecialOfferProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SpecialOfferID")
    private int specialOfferID;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;

    public SpecialOfferProductPK() {
    }

    public SpecialOfferProductPK(int specialOfferID, int productID) {
        this.specialOfferID = specialOfferID;
        this.productID = productID;
    }

    public int getSpecialOfferID() {
        return specialOfferID;
    }

    public void setSpecialOfferID(int specialOfferID) {
        this.specialOfferID = specialOfferID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) specialOfferID;
        hash += (int) productID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialOfferProductPK)) {
            return false;
        }
        SpecialOfferProductPK other = (SpecialOfferProductPK) object;
        if (this.specialOfferID != other.specialOfferID) {
            return false;
        }
        if (this.productID != other.productID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.SpecialOfferProductPK[ specialOfferID=" + specialOfferID + ", productID=" + productID + " ]";
    }
    
}
