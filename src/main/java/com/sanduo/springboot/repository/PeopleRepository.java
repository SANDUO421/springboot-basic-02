package com.sanduo.springboot.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.sanduo.springboot.entity.People;

/**
 * Rest Respository
 * 
 * @author sanduo
 * @date 2018/07/26
 */
@RepositoryRestResource(path = "peoples") // 默认就是peoples,通过@RepositoryRestResource修改
public interface PeopleRepository extends CustomerRepository<People, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    People findByNameStartsWith(@Param("name") String name);

}
