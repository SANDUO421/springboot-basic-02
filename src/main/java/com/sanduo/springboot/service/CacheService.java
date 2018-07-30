package com.sanduo.springboot.service;

import com.sanduo.springboot.entity.Person;

/**
 * cache测试
 * 
 * @author sanduo
 * @date 2018/07/27
 */
public interface CacheService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);
}
