/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "ShipMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShipMethod.findAll", query = "SELECT s FROM ShipMethod s"),
    @NamedQuery(name = "ShipMethod.findByShipMethodID", query = "SELECT s FROM ShipMethod s WHERE s.shipMethodID = :shipMethodID"),
    @NamedQuery(name = "ShipMethod.findByName", query = "SELECT s FROM ShipMethod s WHERE s.name = :name"),
    @NamedQuery(name = "ShipMethod.findByShipBase", query = "SELECT s FROM ShipMethod s WHERE s.shipBase = :shipBase"),
    @NamedQuery(name = "ShipMethod.findByShipRate", query = "SELECT s FROM ShipMethod s WHERE s.shipRate = :shipRate"),
    @NamedQuery(name = "ShipMethod.findByRowguid", query = "SELECT s FROM ShipMethod s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "ShipMethod.findByModifiedDate", query = "SELECT s FROM ShipMethod s WHERE s.modifiedDate = :modifiedDate")})
public class ShipMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShipMethodID")
    private Integer shipMethodID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ShipBase")
    private BigDecimal shipBase;
    @Basic(optional = false)
    @Column(name = "ShipRate")
    private BigDecimal shipRate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public ShipMethod() {
    }

    public ShipMethod(Integer shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public ShipMethod(Integer shipMethodID, String name, BigDecimal shipBase, BigDecimal shipRate, String rowguid, Date modifiedDate) {
        this.shipMethodID = shipMethodID;
        this.name = name;
        this.shipBase = shipBase;
        this.shipRate = shipRate;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(Integer shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getShipBase() {
        return shipBase;
    }

    public void setShipBase(BigDecimal shipBase) {
        this.shipBase = shipBase;
    }

    public BigDecimal getShipRate() {
        return shipRate;
    }

    public void setShipRate(BigDecimal shipRate) {
        this.shipRate = shipRate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipMethodID != null ? shipMethodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipMethod)) {
            return false;
        }
        ShipMethod other = (ShipMethod) object;
        if ((this.shipMethodID == null && other.shipMethodID != null) || (this.shipMethodID != null && !this.shipMethodID.equals(other.shipMethodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.ShipMethod[ shipMethodID=" + shipMethodID + " ]";
    }
    
}
