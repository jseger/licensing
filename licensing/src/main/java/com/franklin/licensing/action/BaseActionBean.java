/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import com.franklin.licensing.ext.ActionBeanContextImpl;
import com.franklin.licensing.repository.ActivationRepositoryInterface;
import com.franklin.licensing.repository.CustomerRepositoryInterface;
import com.franklin.licensing.repository.LicenseRepositoryInterface;
import com.franklin.licensing.repository.ProductRepositoryInterface;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.integration.spring.SpringBean;

/**
 *
 * @author jesse
 */
public abstract class BaseActionBean implements ActionBean {

    @SpringBean("customerRepo")
    protected CustomerRepositoryInterface customerRepository;
    @SpringBean("productRepo")
    protected ProductRepositoryInterface productRepository;
    @SpringBean("licenseRepo")
    protected LicenseRepositoryInterface licenseRepository;
    @SpringBean("activationRepo")
    protected ActivationRepositoryInterface activationRepository;
    
    protected ActionBeanContextImpl _context;
    
    @Override
    public void setContext(ActionBeanContext abc) {
        _context = (ActionBeanContextImpl)abc;
    }

    @Override
    public ActionBeanContext getContext() {
        return _context;
    }
    
}
