/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.Activation;
import java.util.List;

/**
 *
 * @author jesse
 */
public interface ActivationRepositoryInterface extends RepositoryInterface<Integer, Activation>{

    public List<Activation> findByLicenseId(int license_id);
    
    public Activation findByLicenseKeyAndFingerPrint(String key, String fingerprint);
    
    public int getCountByLicenseId(int license_id);
}
