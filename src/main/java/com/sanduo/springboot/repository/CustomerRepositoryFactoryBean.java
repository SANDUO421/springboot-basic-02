package com.sanduo.springboot.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.sanduo.springboot.repository.impl.CustomerRepositoryImpl;

/**
 * 自定义RepositoryFactoryBean
 * 
 * @author sanduo
 * @date 2018/07/06
 */
public class CustomerRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
    extends JpaRepositoryFactoryBean<T, S, ID> {

    /**
     * @param repositoryInterface
     */
    public CustomerRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    /* 创建实例
     * @see org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean#createRepositoryFactory(javax.persistence.EntityManager)
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomerRepositoryFactory(entityManager);// 用当前的factory创建实例
    }

    public static class CustomerRepositoryFactory extends JpaRepositoryFactory {

        /**
         * @param entityManager
         */
        public CustomerRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?>
            getTargetRepository(RepositoryInformation information, EntityManager entityManager) {

            return new CustomerRepositoryImpl<T, ID>((Class<T>)information.getDomainType(), entityManager);// 获取当前自定义的Repository实现

        }

        /* (non-Javadoc)
         * @see org.springframework.data.jpa.repository.support.JpaRepositoryFactory#getRepositoryBaseClass(org.springframework.data.repository.core.RepositoryMetadata)
         */
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomerRepositoryImpl.class;// 获取档期啊自定义的Repository实现的类型
        }
    }
}
