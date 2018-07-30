package com.sanduo.springboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sanduo.springboot.entity.Customer;

/**
 * mongoDB
 * 
 * @author sanduo
 * @date 2018/07/27
 */
public interface MongoDBCustomerRepository extends MongoRepository<Customer, String> {

    // 支持方法名查询
    Customer findByName(String name);

    @Query(value = "{'age':?0}") // 查询构造json字符串
    List<Customer> withQueryFindByAge(Integer age);
}
