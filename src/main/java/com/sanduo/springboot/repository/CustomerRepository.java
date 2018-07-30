package com.sanduo.springboot.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 自定义Repository
 * 
 * @author sanduo
 * @date 2018/07/06
 */
@NoRepositoryBean // 指明当前接口不是领域内的接口
public interface CustomerRepository<T, ID extends Serializable>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {// 具备了Specification的功能

    public void doSomething(ID id);// 定义操作方法

    Page<T> findByAuto(T example, Pageable pageable);
}
