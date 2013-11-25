/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.Activation;
import com.stripersist.Stripersist;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("activationRepo")
public class ActivationRepository extends RepositoryBase<Integer, Activation> 
    implements ActivationRepositoryInterface {

    @Override
    public List<Activation> findAll() {
        return Stripersist.getEntityManager().createNamedQuery(Activation.FIND_ALL).getResultList();
    }
    
    @Override
    public List<Activation> findByLicenseId(int licenseID) {
        return Stripersist.getEntityManager().createNamedQuery(Activation.FIND_BY_LICENSE_ID).setParameter("licenseID", licenseID).getResultList();
    }

    @Override
    public Activation findByLicenseKeyAndFingerPrint(String key, String fingerprint){
        List<Activation> list = Stripersist.getEntityManager()
                .createNamedQuery(Activation.FIND_BY_KEY_FINGERPRINT)
                .setParameter("key", key)
                .setParameter("fingerprint", fingerprint)
                .getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return (Activation)list.get(0);
        }
    }
    
    @Override
    public Long getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getCountByLicenseId(int license_id){
        if(this.findByLicenseId(license_id).isEmpty()){
            return 0;
        }else{
            return this.findByLicenseId(license_id).size();
        }
    }
}
