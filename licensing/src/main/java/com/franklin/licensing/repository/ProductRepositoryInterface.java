
package com.franklin.licensing.repository;

import com.franklin.licensing.entities.Product;

/**
 *
 * @author jesse
 */
public interface ProductRepositoryInterface extends RepositoryInterface<Integer, Product> {
    public Product findByUniqueId(String uniqueId);  
    public Product findByName(String name);
}
