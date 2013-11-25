/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import com.franklin.licensing.entities.Activation;
import com.franklin.licensing.entities.Customer;
import com.franklin.licensing.entities.License;
import com.franklin.licensing.entities.Product;
import java.util.List;
import java.util.UUID;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;


@UrlBinding("/license")
public class LicenseActionBean extends BaseActionBean {
    
    
    private Integer selectedCustomerId;
    private Integer selectedProductId;
    
    private Integer licenseId;
    private License license;
    
      /**
     * @return the licenseId
     */
    public Integer getLicenseId() {
        return licenseId;
    }

    /**
     * @param licenseId the licenseId to set
     */
    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }

    /**
     * @return the license
     */
    public License getLicense() {
        return license;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(License license) {
        this.license = license;
    }
    
        /**
     * @return the selectedCustomer
     */
    public Integer getSelectedCustomerId() {
        return selectedCustomerId;
    }

    /**
     * @param selectedCustomerId the selectedCustomer to set
     */
    public void setSelectedCustomerId(Integer selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }

    /**
     * @return the selectedProductId
     */
    public Integer getSelectedProductId() {
        return selectedProductId;
    }
    
        /**
     * @param selectedProductId the selectedProduct to set
     */
    public void setSelectedProductId(Integer selectedProductId){
        this.selectedProductId = selectedProductId;
    }
    
    public List<Customer> getCustomers(){
        return super.customerRepository.findAll();
    }
    
    public List<Product> getProducts(){
        return super.productRepository.findAll();
    }
    
    public List<License> getLicenses(){
        return super.licenseRepository.findAll();
    }
    
    public List<Activation> getActivations(){
        return super.activationRepository.findAll();
    }
    
    @DefaultHandler
    public Resolution create(){
        this.license = new License();
        return new ForwardResolution("/WEB-INF/jsp/add_license.jsp");
    }
    
    public Resolution save(){ 

        if(this.selectedCustomerId == null){
            getContext().getMessages().add(new SimpleMessage("Please select a customer."));
            return new ForwardResolution("/WEB-INF/jsp/add_license.jsp");
        }
        if(this.selectedProductId  == null){
            getContext().getMessages().add(new SimpleMessage("Please select a product."));
            return new ForwardResolution("/WEB-INF/jsp/add_license.jsp");
        }
        
        if(this.licenseId != null && this.licenseId > 0){
            super.licenseRepository.update(this.license);
        }else{
            if(this.license == null){
                this.license = new License();
            }
            
            UUID unique = UUID.randomUUID();
            this.license.setCustomerID(this.selectedCustomerId.longValue());
            this.license.setProductID(this.selectedProductId.longValue());
            this.license.setLicenseKey(unique.toString());
            super.licenseRepository.save(this.license);
        }
        
        getContext().getMessages().add(new SimpleMessage("License saved."));
        return new ForwardResolution("/WEB-INF/jsp/license_saved.jsp");      
    }
    
    public Resolution cancel() {
        this.license = new License();
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new ForwardResolution("/WEB-INF/jsp/add_license.jsp");
    }
    
    @HandlesEvent("list")
    public Resolution list(){
        return new ForwardResolution("/WEB-INF/jsp/search_license.jsp");
    }
    
    @HandlesEvent("list_activations")
    public Resolution listActivations(){
        return new ForwardResolution("/WEB-INF/jsp/search_activations.jsp");
    }
}
