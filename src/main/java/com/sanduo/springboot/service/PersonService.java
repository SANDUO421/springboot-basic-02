package com.sanduo.springboot.service;

import static com.sanduo.springboot.service.CustomerSpecs.personFromHefei;
// import static com.sanduo.springboot.service.CustomerSpecs.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sanduo.springboot.entity.Person;
import com.sanduo.springboot.repository.PersonRepository;

/**
 * 静态导入测试和标准规范查询
 * 
 * @author sanduo
 * @date 2018/07/05
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 标准规范查询
     * 
     * @return
     */
    public List<Person> findAll() {
        return personRepository.findAll(personFromHefei());
    }

    /**
     * 排序
     * 
     * @return
     */
    public List<Person> findByName(String name, String sort) {

        return personRepository.findByName(name, new Sort(Direction.ASC, "age"));
    }

    public List<Person> findByName() {

        return personRepository.findByName("xxx", PageRequest.of(0, 1));
    }

    public Person findByNameAndAddress(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }

    public Person withNameAndAddressQuery(String name, String address) {
        return personRepository.withNameAndAddressQuery(name, address);
    }

    public List<Person> withNameAndAddressNamedQuery(String name, String address) {
        return personRepository.withNameAndAddressNamedQuery(name, address);
    }

    /**
     * 保存
     * 
     * @param object
     * @param name
     * @param age
     * @param address
     * @return
     */
    public Person save(Object object, String name, Integer age, String address) {
        Person entity = new Person();
        entity.setId(null);
        if (name != null && age != null && address != null) {
            entity.setName(name);
            entity.setAge(age);
            entity.setAddress(address);
            return personRepository.save(entity);
        }
        return null;

    }

    /**
     * 根据地址查询
     * 
     * @param address
     * @return
     */
    public List<Person> findByAddress(String address) {
        return personRepository.findByAddress(address);
    }

    /**
     * @param desc
     * @param string
     * @return
     */
    public List<Person> findAll(Sort sort) {
        return personRepository.findAll(sort);
    }

    /**
     * @param of
     * @return
     */
    public Page<Person> page(PageRequest pageable) {
        Page<Person> people = personRepository.findAll(pageable);
        return people;
    }

    /**
     * @param person
     * @param of
     * @return
     */
    public Page<Person> findByAuto(Person person, PageRequest pageable) {
        return personRepository.findByAuto(person, pageable);
    }
}
