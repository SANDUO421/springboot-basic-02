package com.sanduo.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanduo.springboot.entity.Person;
import com.sanduo.springboot.repository.TransactionPersonRepository;
import com.sanduo.springboot.service.TransactionPersonService;

/**
 * 事务业务
 * 
 * @author sanduo
 * @date 2018/07/26
 */
@Service
public class TransactionPersonServiceImpl implements TransactionPersonService {

    @Autowired
    private TransactionPersonRepository transactionPersonRepository;

    /* 保存用户带回滚
     * @see com.sanduo.springboot.service.TransactionPersonService#savePersonWithRollBack(com.sanduo.springboot.entity.Person)
     */
    @Override
    @Transactional(rollbackOn = {IllegalArgumentException.class}) // rollbackOn指定特定异常，数据将会回滚
    public Person savePersonWithRollBack(Person person) {
        Person p = transactionPersonRepository.save(person);
        if (p.getName().equals("sanduo")) {
            throw new IllegalArgumentException("sanduo已经存在，数据将回滚，不被保存");// 手动触发异常
        }
        return p;
    }

    /* 保存用户不带回滚
     * @see com.sanduo.springboot.service.TransactionPersonService#savePersonWithoutRollBack(com.sanduo.springboot.entity.Person)
     */
    @Override
    @Transactional(dontRollbackOn = {IllegalArgumentException.class}) // dontRollbackOn特定异常数据不会回滚
    public Person savePersonWithnoRollBack(Person person) {
        Person p = transactionPersonRepository.save(person);
        if (p.getName().equals("sanduo")) {
            throw new IllegalArgumentException("sanduo虽然已经存在，但是数据将不回滚，会保存");
        }
        return null;
    }

}
