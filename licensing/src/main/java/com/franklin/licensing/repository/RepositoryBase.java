/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.repository;

import com.stripersist.Stripersist;
import java.lang.reflect.ParameterizedType;
import javax.annotation.PostConstruct;

/**
 *
 * @author jesse
 */
public abstract class RepositoryBase<K, E extends EntityBase> implements RepositoryInterface<K, E> {

    protected Class<E> entityClass;
    
    @PostConstruct
    public void init(){
        Stripersist.requestInit();
        ParameterizedType genericSuperClass = (ParameterizedType)getClass().getGenericSuperclass();
        this.entityClass = (Class<E>)genericSuperClass.getActualTypeArguments()[1];      
    }

    @Override
    public E find(int id) {
        return Stripersist.getEntityManager().find(entityClass, id);
    }

    @Override
    public E save(E entity) {
        Stripersist.getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public E update(E entity) {
        return Stripersist.getEntityManager().merge(entity);
    }

    @Override
    public void remove(E entity) {
        Stripersist.getEntityManager().remove(Stripersist.getEntityManager().merge(entity));
    }   
}
