
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.Customer;
import com.stripersist.Stripersist;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jesse
 */
@Repository("customerRepo")
public class CustomerRepository extends RepositoryBase<Integer, Customer> 
    implements CustomerRepositoryInterface {
    
    @Override
    public void init(){ 
        super.init();
    }
    
    @Override
    public Customer findByEmail(String email){
        List list = Stripersist.getEntityManager().createNamedQuery(Customer.FIND_BY_EMAIL).setParameter("email", email).getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return (Customer)list.get(0);
        }
    }
    
    @Override
    public Customer findByName(String name){
        List list = Stripersist.getEntityManager().createNamedQuery(Customer.FIND_BY_NAME).setParameter("name", name).getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return (Customer)list.get(0);
        }
    }

    @Override
    public List<Customer> findAll() {
        return Stripersist.getEntityManager().createNamedQuery(Customer.FIND_ALL).getResultList();
    }

    @Override
    public Long getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
