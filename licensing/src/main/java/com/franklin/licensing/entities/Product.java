
package com.franklin.licensing.entities;

import com.franklin.licensing.repository.EntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 *
 * @author Tim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Product.FIND_BY_UID, query = "select p from Product p where p.uniqueId = :uniqueId"),
    @NamedQuery(name = Product.FIND_BY_NAME, query = "select p from Product p where p.name = :name"),
    @NamedQuery(name = Product.FIND_ALL, query = "select p from Product p")
})
public class Product extends EntityBase{
    
    public static final String FIND_ALL = "Product.findAll";
    
    public static final String FIND_BY_UID = "Product.findByUniqueId";
    
    public static final String FIND_BY_NAME = "Product.findByName";
    
    @Column(name ="unique_id")
    private String uniqueId;
    @Column(name ="product_name")
    private String name;
    @Column(name = "product_description")
    private String description;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
