package com.sanduo.springboot.service;

import com.sanduo.springboot.entity.Person;

/**
 * 事务接口
 * 
 * @author sanduo
 * @date 2018/07/26
 */
public interface TransactionPersonService {

    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithnoRollBack(Person person);
}
