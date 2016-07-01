package com.studevs.mvc.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id ;
    
    @Column(name = "CLIENT_NAME", nullable = false)
    private String clientName ;
    
    @Column(name = "CLIENT_PHONE_NUMBER", nullable = false)
    private String clientPhoneNumber ;
    
    @Column(name = "CLIENT_EMAIL", nullable = false)
    private String clientEmail ;
    
    @Column(name = "CLIENT_BKASH_NUMBER", nullable = false)
    private String clientBkshNumber ;
    
    @Column(name = "TRANSACTION_NUMBER", nullable = false)
    private String transactionNumber ;
    
    @Column(name = "ADVANCED_AMOUNT", nullable = false)
    private Integer advancedAmount ;
    
    @Column(name = "EVENT_VENUE", nullable = false, length = 500)
    private String eventVenue ;
    
    @Column(name = "EVENT_DATE", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eventDate;
    
    @Column(name = "DELIVERY_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deliveryDate ;
    
    @Column(name = "IS_FULL_PAID")
    private Boolean isFullPaid ;
    
    @Column(name = "IS_APPOINTED")
    private Boolean isAppointed ;
    
    @Column(name = "IS_DELIVERED")
    private Boolean isdelivered ;
    
    @ManyToOne(targetEntity = OurPackages.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private OurPackages ourPackages;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.clientName);
        hash = 23 * hash + Objects.hashCode(this.clientPhoneNumber);
        hash = 23 * hash + Objects.hashCode(this.clientEmail);
        hash = 23 * hash + Objects.hashCode(this.clientBkshNumber);
        hash = 23 * hash + Objects.hashCode(this.transactionNumber);
        hash = 23 * hash + Objects.hashCode(this.advancedAmount);
        hash = 23 * hash + Objects.hashCode(this.eventVenue);
        hash = 23 * hash + Objects.hashCode(this.eventDate);
        hash = 23 * hash + Objects.hashCode(this.deliveryDate);
        hash = 23 * hash + Objects.hashCode(this.isFullPaid);
        hash = 23 * hash + Objects.hashCode(this.isAppointed);
        hash = 23 * hash + Objects.hashCode(this.isdelivered);
        hash = 23 * hash + Objects.hashCode(this.ourPackages);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.clientName, other.clientName)) {
            return false;
        }
        if (!Objects.equals(this.clientPhoneNumber, other.clientPhoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.clientEmail, other.clientEmail)) {
            return false;
        }
        if (!Objects.equals(this.clientBkshNumber, other.clientBkshNumber)) {
            return false;
        }
        if (!Objects.equals(this.transactionNumber, other.transactionNumber)) {
            return false;
        }
        if (!Objects.equals(this.eventVenue, other.eventVenue)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.advancedAmount, other.advancedAmount)) {
            return false;
        }
        if (!Objects.equals(this.eventDate, other.eventDate)) {
            return false;
        }
        if (!Objects.equals(this.deliveryDate, other.deliveryDate)) {
            return false;
        }
        if (!Objects.equals(this.isFullPaid, other.isFullPaid)) {
            return false;
        }
        if (!Objects.equals(this.isAppointed, other.isAppointed)) {
            return false;
        }
        if (!Objects.equals(this.isdelivered, other.isdelivered)) {
            return false;
        }
        return Objects.equals(this.ourPackages, other.ourPackages);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientBkshNumber() {
        return clientBkshNumber;
    }

    public void setClientBkshNumber(String clientBkshNumber) {
        this.clientBkshNumber = clientBkshNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Integer getAdvancedAmount() {
        return advancedAmount;
    }

    public void setAdvancedAmount(Integer advancedAmount) {
        this.advancedAmount = advancedAmount;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getIsFullPaid() {
        return isFullPaid;
    }

    public void setIsFullPaid(Boolean isFullPaid) {
        this.isFullPaid = isFullPaid;
    }

    public Boolean getIsAppointed() {
        return isAppointed;
    }

    public void setIsAppointed(Boolean isAppointed) {
        this.isAppointed = isAppointed;
    }

    public Boolean getIsdelivered() {
        return isdelivered;
    }

    public void setIsdelivered(Boolean isdelivered) {
        this.isdelivered = isdelivered;
    }

    public OurPackages getOurPackages() {
        return ourPackages;
    }

    public void setOurPackages(OurPackages ourPackages) {
        this.ourPackages = ourPackages;
    }

    public Orders() {
    }
}
