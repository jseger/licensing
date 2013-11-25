/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.License;
import com.stripersist.Stripersist;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jesse
 */
@Repository("licenseRepo")
public class LicenseRepository extends RepositoryBase<Integer, License> 
    implements LicenseRepositoryInterface {

    @Override
    public License findByKey(String key) {
        List list = Stripersist.getEntityManager().createNamedQuery(License.FIND_BY_KEY).setParameter("key", key).getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return (License)list.get(0);
        }
    }

    @Override
    public List<License> findAll() {
        return Stripersist.getEntityManager().createNamedQuery(License.FIND_ALL).getResultList();
    }

    @Override
    public Long getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}