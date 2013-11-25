/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import com.franklin.licensing.entities.Product;
import java.util.List;
import net.sourceforge.stripes.action.*;
import java.util.UUID;

/**
 *
 * @author Tim
 */
@UrlBinding("/product")
public class ProductActionBean extends BaseActionBean {
    Integer productId;
    Product product;
    
     /**
     * @return the productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    /**
     * @return the product
     */
    public Product getProduct() {
        if(productId != null){
            return (Product)super.productRepository.find(this.productId);
        }
        
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public List<Product> getProducts(){
        return super.productRepository.findAll();
    }
    
    @DefaultHandler
    public Resolution create(){
        return new ForwardResolution("/WEB-INF/jsp/add_product.jsp");
    }
    
    public Resolution save() {
        if (this.product != null) {
            if (this.productId == null) {
                UUID unique = UUID.randomUUID();
                this.product.setUniqueId(unique.toString());
                this.product = (Product) super.productRepository.save(product);
            } else {
                this.product = (Product) super.productRepository.update(product);
            }
            getContext().getMessages().add(new SimpleMessage("Product saved."));
            return new ForwardResolution("/WEB-INF/jsp/product_added.jsp");
        }

        return new ForwardResolution("/WEB-INF/jsp/add_product.jsp");
    }
    
    public Resolution cancel() {
        this.product.setName("");
        this.product.setUniqueId("");
        this.product.setDescription("");
        getContext().getMessages().add(new SimpleMessage("Action cancelled."));
        return new ForwardResolution("/WEB-INF/jsp/add_product.jsp");
    }
    
    @HandlesEvent("list")
    public Resolution list(){
        return new ForwardResolution("/WEB-INF/jsp/search_products.jsp");
    }
}
