package com.sanduo.springboot.repository.impl;

// 静态导入
import static com.sanduo.springboot.service.CustomerSpecs.byAuto;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.sanduo.springboot.repository.CustomerRepository;

/**
 * 自定义分页和排序接口实现
 * 
 * @author sanduo
 * @date 2018/07/06
 */
public class CustomerRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements CustomerRepository<T, ID> {// 继承SimpleJpaRepository可以使用基本的方法，如findAll()

    private final EntityManager entityManager;

    /**
     * @param domainClass
     * @param em
     */
    public CustomerRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;

    }

    /* 实现
     * @see com.sanduo.springboot.repository.CustomerRepository#doSomething(java.io.Serializable)
     */
    @Override
    public void doSomething(ID id) {
        // TODO Auto-generated method stub

    }

    /* 条件查询，并提供分页功能
     * @see com.sanduo.springboot.repository.CustomerRepository#findByAuto(java.lang.Object, org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager, example), pageable);
    }

}
