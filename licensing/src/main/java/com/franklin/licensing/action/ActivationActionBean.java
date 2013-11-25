/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import com.franklin.licensing.entities.Activation;
import com.franklin.licensing.entities.License;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import org.json.JSONObject;

/**
 *
 * @author Tim
 */
@UrlBinding("/api/{$event}/{productId}/{licenseKey}/{machineFingerprint}")
public class ActivationActionBean extends BaseActionBean {
    private Activation activation;
    @Validate(required=true, minlength=10, maxlength=100)
    private String productId;
    @Validate(required=true, minlength=10, maxlength=100)
    private String licenseKey;
    @Validate(required=true, minlength=10, maxlength=100)
    private String machineFingerprint;
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }
    
    public void setMachineFingerprint(String machineFingerprint) {
        this.machineFingerprint = machineFingerprint;
    }
    
    private HashMap<String, Object> getHashMap() {
        HashMap<String, Object> hMap = new HashMap<String, Object>();
        hMap.put("isLicenseValid", false);
        hMap.put("isActivated", false);
        hMap.put("expirationDate", "1/1/1970");
        hMap.put("numberOfActivations", 0);
        hMap.put("maxActivations", 0);
        hMap.put("licenseKey", this.licenseKey);
        hMap.put("message", "");
        return hMap;
    }
    
    @HandlesEvent("activate")
    public Resolution activate() {
        StreamingResolution resolution = null;
        HashMap hMap = getHashMap();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
        
        License lic = super.licenseRepository.findByKey(licenseKey);
        
        if(lic != null){    
            if (lic.getProduct().getUniqueId().equalsIgnoreCase(this.productId)) {
                if (new Date().compareTo(lic.getExpirationDate()) < 0) {
                    this.activation = super.activationRepository
                            .findByLicenseKeyAndFingerPrint(lic.getLicenseKey(), this.machineFingerprint);
                    int count = super.activationRepository.getCountByLicenseId(lic.getId().intValue());
                    if(this.activation != null){
                        // everything is successful
                        hMap.put("isLicenseValid", true);
                        hMap.put("isActivated", true);
                        hMap.put("expirationDate", dateFormat.format(lic.getExpirationDate()));
                        hMap.put("numberOfActivations", count);
                        hMap.put("maxActivations", lic.getMaxActivations());
                        hMap.put("message", "Success");
                    }else{                     
                        if(lic.getMaxActivations() == 0 || count < lic.getMaxActivations()){
                            this.activation = new Activation();
                            this.activation.setLicenseID(lic.getId().intValue());
                            this.activation.setFingerprint(machineFingerprint);
                            this.activation.setActivationDate(new Date());
                            this.activation = super.activationRepository.save(this.activation);
                            hMap.put("isLicenseValid", true);
                            hMap.put("isActivated", true);
                            hMap.put("expirationDate", dateFormat.format(lic.getExpirationDate()));
                            hMap.put("numberOfActivations", count);
                            hMap.put("maxActivations", lic.getMaxActivations());
                            hMap.put("message", "Success");
                        }else{
                            hMap.put("message", "The license has reached the maximum number of activations");
                        }
                    }
                }else{
                    hMap.put("expirationDate", dateFormat.format(lic.getExpirationDate()));
                    hMap.put("message", "License has expired");
                }            
            }else{
                hMap.put("message", "Product not found");
            }
        }else{
            hMap.put("message", "The license key is invalid");
        }
        
        resolution = new StreamingResolution("application/json", new JSONObject(hMap).toString());
        
        return resolution;
    }
    
    @HandlesEvent("check")
    public Resolution check() {
        StreamingResolution resolution = null;
        
        License lic_record = super.licenseRepository.findByKey(this.licenseKey);
        
        //resolution = getJson(lic_record);
        
        return resolution;
    }       
    
}
