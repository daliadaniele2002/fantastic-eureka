package com.github.fantastic_eureka.sneakers_store_ee.dao;

import java.io.Serializable;

public class GenericJpaDao<T extends Serializable>
        extends AbstractJpaDao<T> implements IGenericDao<T>{
}
