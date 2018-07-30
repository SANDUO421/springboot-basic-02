package com.sanduo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanduo.springboot.entity.Person;
import com.sanduo.springboot.service.PersonService;

/**
 * jpa controller
 * 
 * @author sanduo
 * @date 2018/07/09
 */
@RestController(value = "data")
public class DataController {

    @Autowired
    private PersonService personService;

    /**
     * 测试保存
     * 
     * @param name
     * @param age
     * @param address
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public Person save(String name, Integer age, String address) {
        Person p = personService.save(null, name, age, address);

        return p;
    }

    /**
     * 测试 findByAddress
     * 
     * @param address
     * @return
     */
    @RequestMapping(value = "/findByAddress", method = RequestMethod.GET)
    public List<Person> findByAddress(String address) {
        List<Person> people = personService.findByAddress(address);
        return people;
    }

    @RequestMapping(value = "/findByNameAndAddress", method = RequestMethod.GET)
    public Person findByNameAndAddress(String name, String address) {
        Person people = personService.findByNameAndAddress(name, address);
        return people;
    }

    @RequestMapping(value = "/withNameAndAddressQuery", method = RequestMethod.GET)
    public Person withNameAndAddressQuery(String name, String address) {
        Person people = personService.withNameAndAddressQuery(name, address);
        return people;
    }

    @RequestMapping(value = "/withNameAndAddressNamedQuery", method = RequestMethod.GET)
    public List<Person> withNameAndAddressNamedQuery(String name, String address) {
        List<Person> people = personService.withNameAndAddressNamedQuery(name, address);
        return people;
    }

    /**
     * 排序
     * 
     * @return
     */
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public List<Person> sort() {
        List<Person> people = personService.findAll(new Sort(Direction.DESC, "age"));
        return people;
    }

    /**
     * 分页针对不同的数据库必须配置方言，否则会报错
     * 
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Person> page() {
        Page<Person> people = personService.page(PageRequest.of(1, 2, Sort.Direction.ASC, "age"));
        // Page<Person> people = personService.page(PageRequest.of(0, 3, Direction.ASC, "age"));
        return people;
    }

    @RequestMapping(value = "/auto", method = RequestMethod.GET)
    public Page<Person> auto(Person person) {
        // XXX 这快代码目前不能正常运行，因为反射有误
        Page<Person> people = personService.findByAuto(person, PageRequest.of(0, 3));
        return people;
    }

}
