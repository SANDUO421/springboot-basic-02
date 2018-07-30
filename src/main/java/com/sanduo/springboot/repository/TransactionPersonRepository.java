package com.sanduo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanduo.springboot.entity.Person;

/**
 * 事务的测试接口
 * 
 * @author sanduo
 * @date 2018/07/26
 */
public interface TransactionPersonRepository extends JpaRepository<Person, Long> {

}
