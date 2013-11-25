/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.Customer;

/**
 *
 * @author jesse
 */
public interface CustomerRepositoryInterface extends RepositoryInterface<Integer, Customer> {
    public Customer findByEmail(String email);  
    public Customer findByName(String name);
}
