package com.franklin.licensing.entities;

import com.franklin.licensing.repository.EntityBase;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Tim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = License.FIND_BY_KEY, query = "select l from License l where l.licenseKey = :key"),
    @NamedQuery(name = License.FIND_ALL, query = "select l from License l")
})
public class License extends EntityBase{
    
    public static final String FIND_BY_KEY = "License.findByKey";
    
    public static final String FIND_ALL = "License.findAll";
    
    @Column(name = "license_key")
    private String licenseKey;
    @Column(name = "product_id")
    private Long productID;
    @Column(name = "customer_id")
    private Long customerID;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "max_activations")
    private int maxActivations;
    @ManyToOne(cascade=CascadeType.REFRESH) 
    @JoinColumn(name="customer_id", insertable=false, updatable=false)
    private Customer customer;
    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="product_id", insertable=false, updatable=false)
    private Product product;
    
    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        if(expirationDate == null) {
            expirationDate = new Date(Long.MAX_VALUE);  
        }
        this.expirationDate = expirationDate;
    }
    
    /**
     * Set the expiration date by creating a new Date object.
     * 
     * @param year the expiration year
     * @param mon the expiration month
     * @param day the expiration day
     * @param hour the expiration hour
     * @param min the expiration minute
     * @param sec the expiration second
     */
    public void setExpirationDate(int year, int mon, int day, int hour,
            int min, int sec) {
        this.expirationDate = new Date(year, mon, day, hour, min, sec);
    }

    

    public int getMaxActivations() {
        return maxActivations;
    }

    public void setMaxActivations(int maxActivations) {
        this.maxActivations = maxActivations;
    }
    
    
    // navigation properties
    public Customer getCustomer(){
        return this.customer;
    }
    
    public Product getProduct(){
        return this.product;
    }
}
