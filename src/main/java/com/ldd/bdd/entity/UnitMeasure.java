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
@Table(name = "UnitMeasure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitMeasure.findAll", query = "SELECT u FROM UnitMeasure u"),
    @NamedQuery(name = "UnitMeasure.findByUnitMeasureCode", query = "SELECT u FROM UnitMeasure u WHERE u.unitMeasureCode = :unitMeasureCode"),
    @NamedQuery(name = "UnitMeasure.findByName", query = "SELECT u FROM UnitMeasure u WHERE u.name = :name"),
    @NamedQuery(name = "UnitMeasure.findByModifiedDate", query = "SELECT u FROM UnitMeasure u WHERE u.modifiedDate = :modifiedDate")})
public class UnitMeasure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode")
    private String unitMeasureCode;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "sizeUnitMeasureCode")
    private List<Product> productList;
    @OneToMany(mappedBy = "weightUnitMeasureCode")
    private List<Product> productList1;

    public UnitMeasure() {
    }

    public UnitMeasure(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }

    public UnitMeasure(String unitMeasureCode, String name, Date modifiedDate) {
        this.unitMeasureCode = unitMeasureCode;
        this.name = name;
        this.modifiedDate = modifiedDate;
    }

    public String getUnitMeasureCode() {
        return unitMeasureCode;
    }

    public void setUnitMeasureCode(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public List<Product> getProductList1() {
        return productList1;
    }

    public void setProductList1(List<Product> productList1) {
        this.productList1 = productList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitMeasureCode != null ? unitMeasureCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitMeasure)) {
            return false;
        }
        UnitMeasure other = (UnitMeasure) object;
        if ((this.unitMeasureCode == null && other.unitMeasureCode != null) || (this.unitMeasureCode != null && !this.unitMeasureCode.equals(other.unitMeasureCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.UnitMeasure[ unitMeasureCode=" + unitMeasureCode + " ]";
    }
    
}
