
package com.franklin.licensing.entities;

import com.franklin.licensing.repository.EntityBase;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Activation.FIND_BY_LICENSE_ID, query = "select a from Activation a where a.licenseID = :licenseID"),
    @NamedQuery(name = Activation.FIND_ALL, query = "select a from Activation a"),
    @NamedQuery(name = Activation.FIND_BY_KEY_FINGERPRINT, query = "select a from Activation a where a.license.licenseKey = :key and a.fingerprint = :fingerprint")
})
public class Activation extends EntityBase{
    public static final String FIND_BY_LICENSE_ID = "Activation.findByLicenseId";
    
    public static final String FIND_ALL = "Activation.findAll";
    
    public static final String FIND_BY_KEY_FINGERPRINT = "Activation.findByKeyFingerprint";
    
    @Column(name = "license_id")
    private int licenseID;
    private String fingerprint;
    @Column(name = "activation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;

    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="license_id", insertable=false, updatable=false)
    private License license;
    
    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }
    
    /**
     * Set the activation date by creating a new Date object.
     * 
     * @param year the expiration year
     * @param mon the expiration month
     * @param day the expiration day
     * @param hour the expiration hour
     * @param min the expiration minute
     * @param sec the expiration second
     */
    public void setActivationDate(int year, int mon, int day, int hour,
            int min, int sec) {
        this.activationDate = new Date(year, mon, day, hour, min, sec);
    }
    
    public License getLicense(){
        return this.license;
    }
}
