
package com.franklin.licensing.entities;

import com.franklin.licensing.repository.EntityBase;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Tim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Customer.FIND_BY_EMAIL, query = "select c from Customer c where c.email = :email"),
    @NamedQuery(name = Customer.FIND_BY_NAME, query = "select c from Customer c where c.name = :name"),
    @NamedQuery(name = Customer.FIND_ALL, query = "select c from Customer c")
})
public class Customer extends EntityBase {
 
    public static final String FIND_ALL = "Customer.findAll";
    
    public static final String FIND_BY_EMAIL = "Customer.findByEmail";
    
    public static final String FIND_BY_NAME = "Customer.findByName";
    
    private String name;
    private String email;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
