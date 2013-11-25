
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.Product;
import com.stripersist.Stripersist;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jesse
 */
@Repository("productRepo")
public class ProductRepository extends RepositoryBase<Integer, Product> 
    implements ProductRepositoryInterface {
    
    @Override
    public void init(){ 
        super.init();
    }
    
    @Override
    public Product findByUniqueId(String uniqueId){
        List list = Stripersist.getEntityManager().createNamedQuery(Product.FIND_BY_UID).setParameter("uniqueId", uniqueId).getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return (Product)list.get(0);
        }
    }
    
    @Override
    public Product findByName(String name){
        List list = Stripersist.getEntityManager().createNamedQuery(Product.FIND_BY_NAME).setParameter("name", name).getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return (Product)list.get(0);
        }
    }
    
    @Override
    public List<Product> findAll(){
        return Stripersist.getEntityManager().createNamedQuery(Product.FIND_ALL).getResultList();
    }

    @Override
    public Long getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
