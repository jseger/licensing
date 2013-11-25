/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import com.franklin.licensing.entities.Customer;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;


public class MockDataLoaderActionBean extends BaseActionBean {
     @DefaultHandler
    public Resolution loadMockUser() throws Exception {
        if (super.customerRepository.findByEmail("email@email.com") == null) {
            Customer cust = new Customer();

            cust.setName("FirstName LastName");
            cust.setEmail("email@email.com");
            super.customerRepository.save(cust);

            
        }
        else {
            
        }
        return new RedirectResolution(CustomerActionBean.class);
    }
}
