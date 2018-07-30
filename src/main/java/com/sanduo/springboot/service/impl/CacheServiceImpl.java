package com.sanduo.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sanduo.springboot.entity.Person;
import com.sanduo.springboot.repository.TransactionPersonRepository;
import com.sanduo.springboot.service.CacheService;

/**
 * 
 * @author sanduo
 * @date 2018/07/27
 */
@Service
public class CacheServiceImpl implements CacheService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private TransactionPersonRepository cachePersonReposotory;

    /*保存
     * @see com.sanduo.springboot.service.CacheService#save(com.sanduo.springboot.entity.Person)
     */
    @Override
    @CachePut(value = "people", key = "#person.id") // 新增或者更新数据库时使用
    public Person save(Person person) {

        Person p = cachePersonReposotory.save(person);
        LOG.debug("id,key为：" + p.getId() + "数据做缓存");
        return p;
    }

    /* 移除
     * @see com.sanduo.springboot.service.CacheService#remove(java.lang.Long)
     */
    @Override
    @CacheEvict(value = "people") // 从缓存中删除key为id的数据
    public void remove(Long id) {
        LOG.debug("通过id，key为" + id + "清除数据缓存");
        cachePersonReposotory.deleteById(id);
    }

    /* 查找
     * @see com.sanduo.springboot.service.CacheService#findOne(com.sanduo.springboot.entity.Person)
     */
    @Override
    @Cacheable(value = "people", key = "#person.id") // 缓存key为id的数据到缓存people中
    public Person findOne(Person person) {
        Person p = cachePersonReposotory.findById(person.getId()).get();
        LOG.debug("为id，key为" + p.getId() + "数据做缓存");
        return p;
    }

}
