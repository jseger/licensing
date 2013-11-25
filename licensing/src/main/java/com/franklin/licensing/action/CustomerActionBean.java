/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import com.franklin.licensing.entities.Customer;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/customer")
public class CustomerActionBean extends BaseActionBean {

    private Integer customerId;
    private Customer customer;
    
    /**
     * @return the customerId
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        if(customerId != null){
            return (Customer)super.customerRepository.find(this.customerId);
        }
        
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public List<Customer> getCustomers(){
        return super.customerRepository.findAll();
    }
    
    @DefaultHandler
    public Resolution create(){
        return new ForwardResolution("/WEB-INF/jsp/add_customer.jsp");
    }
    
    public Resolution save(){      
        if(this.customer != null){
            if(super.customerRepository.findByEmail(this.customer.getEmail()) != null){
                getContext().getMessages().add(new SimpleMessage("Customer already exists."));
            }else{
                if(this.customerId == null){
                    this.customer = (Customer)super.customerRepository.save(customer);
                }else{
                    this.customer = (Customer)super.customerRepository.update(customer);
                }
                getContext().getMessages().add(new SimpleMessage("Customer saved."));
            }
        }
        return new ForwardResolution("/WEB-INF/jsp/add_customer.jsp");
    }
    
    public Resolution cancel() {
        this.customer.setName("");
        this.customer.setEmail("");
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new ForwardResolution("/WEB-INF/jsp/add_customer.jsp");
    }

    @HandlesEvent("list")
    public Resolution list(){
        return new ForwardResolution("/WEB-INF/jsp/search_customers.jsp");
    }
}
