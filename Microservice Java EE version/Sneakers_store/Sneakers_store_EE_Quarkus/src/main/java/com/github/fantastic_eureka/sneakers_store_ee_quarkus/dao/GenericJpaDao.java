package com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao;

import javax.enterprise.context.Dependent;
import java.io.Serializable;

@Dependent
public class GenericJpaDao<T extends Serializable>
        extends AbstractJpaDao<T> implements IGenericDao<T>{
}
