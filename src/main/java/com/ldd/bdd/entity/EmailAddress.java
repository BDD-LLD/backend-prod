/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EmailAddress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailAddress.findAll", query = "SELECT e FROM EmailAddress e"),
    @NamedQuery(name = "EmailAddress.findByBusinessEntityID", query = "SELECT e FROM EmailAddress e WHERE e.emailAddressPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "EmailAddress.findByEmailAddressID", query = "SELECT e FROM EmailAddress e WHERE e.emailAddressPK.emailAddressID = :emailAddressID"),
    @NamedQuery(name = "EmailAddress.findByEmailAddress", query = "SELECT e FROM EmailAddress e WHERE e.emailAddress = :emailAddress"),
    @NamedQuery(name = "EmailAddress.findByRowguid", query = "SELECT e FROM EmailAddress e WHERE e.rowguid = :rowguid"),
    @NamedQuery(name = "EmailAddress.findByModifiedDate", query = "SELECT e FROM EmailAddress e WHERE e.modifiedDate = :modifiedDate")})
public class EmailAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailAddressPK emailAddressPK;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public EmailAddress() {
    }

    public EmailAddress(EmailAddressPK emailAddressPK) {
        this.emailAddressPK = emailAddressPK;
    }

    public EmailAddress(EmailAddressPK emailAddressPK, String rowguid, Date modifiedDate) {
        this.emailAddressPK = emailAddressPK;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public EmailAddress(int businessEntityID, int emailAddressID) {
        this.emailAddressPK = new EmailAddressPK(businessEntityID, emailAddressID);
    }

    public EmailAddressPK getEmailAddressPK() {
        return emailAddressPK;
    }

    public void setEmailAddressPK(EmailAddressPK emailAddressPK) {
        this.emailAddressPK = emailAddressPK;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailAddressPK != null ? emailAddressPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailAddress)) {
            return false;
        }
        EmailAddress other = (EmailAddress) object;
        if ((this.emailAddressPK == null && other.emailAddressPK != null) || (this.emailAddressPK != null && !this.emailAddressPK.equals(other.emailAddressPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.EmailAddress[ emailAddressPK=" + emailAddressPK + " ]";
    }
    
}
