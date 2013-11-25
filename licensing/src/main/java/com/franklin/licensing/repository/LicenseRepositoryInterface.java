
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.License;

/**
 *
 * @author jesse
 */
public interface LicenseRepositoryInterface extends RepositoryInterface<Integer, License> {
    public License findByKey(String key);  
}
