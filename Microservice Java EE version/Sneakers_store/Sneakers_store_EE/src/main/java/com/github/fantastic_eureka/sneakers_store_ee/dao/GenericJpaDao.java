package com.github.fantastic_eureka.sneakers_store_ee.dao;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@RequestScoped
public class GenericJpaDao<T extends Serializable>
        extends AbstractJpaDao<T> implements IGenericDao<T>{
}
