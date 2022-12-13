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
@Table(name = "CreditCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCard.findAll", query = "SELECT c FROM CreditCard c"),
    @NamedQuery(name = "CreditCard.findByCreditCardID", query = "SELECT c FROM CreditCard c WHERE c.creditCardID = :creditCardID"),
    @NamedQuery(name = "CreditCard.findByCardType", query = "SELECT c FROM CreditCard c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CreditCard.findByCardNumber", query = "SELECT c FROM CreditCard c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "CreditCard.findByExpMonth", query = "SELECT c FROM CreditCard c WHERE c.expMonth = :expMonth"),
    @NamedQuery(name = "CreditCard.findByExpYear", query = "SELECT c FROM CreditCard c WHERE c.expYear = :expYear"),
    @NamedQuery(name = "CreditCard.findByModifiedDate", query = "SELECT c FROM CreditCard c WHERE c.modifiedDate = :modifiedDate")})
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CreditCardID")
    private Integer creditCardID;
    @Basic(optional = false)
    @Column(name = "CardType")
    private String cardType;
    @Basic(optional = false)
    @Column(name = "CardNumber")
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "ExpMonth")
    private short expMonth;
    @Basic(optional = false)
    @Column(name = "ExpYear")
    private short expYear;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "creditCardID")
    private List<SalesOrderHeader> salesOrderHeaderList;

    public CreditCard() {
    }

    public CreditCard(Integer creditCardID) {
        this.creditCardID = creditCardID;
    }

    public CreditCard(Integer creditCardID, String cardType, String cardNumber, short expMonth, short expYear, Date modifiedDate) {
        this.creditCardID = creditCardID;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.modifiedDate = modifiedDate;
    }

    public Integer getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(Integer creditCardID) {
        this.creditCardID = creditCardID;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public short getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(short expMonth) {
        this.expMonth = expMonth;
    }

    public short getExpYear() {
        return expYear;
    }

    public void setExpYear(short expYear) {
        this.expYear = expYear;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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
        hash += (creditCardID != null ? creditCardID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.creditCardID == null && other.creditCardID != null) || (this.creditCardID != null && !this.creditCardID.equals(other.creditCardID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.CreditCard[ creditCardID=" + creditCardID + " ]";
    }
    
}
