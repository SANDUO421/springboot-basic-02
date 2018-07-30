package com.sanduo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanduo.springboot.entity.Customer;
import com.sanduo.springboot.repository.MongoDBCustomerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * mongoController
 * 
 * @author sanduo
 * @date 2018/07/27
 */
@Api(description = "mongoDB 测试")
@RestController
public class MongoDBController {

    @Autowired
    private MongoDBCustomerRepository repository;

    // 保存
    /**
     * 测试数据：{ "age": 33, "locations": [ { "place": "西安", "year": "2008" }, { "place": "上海", "year": "2009" }, { "place":
     * "北京", "year": "2010" }, { "place": "深圳", "year": "2011" }, { "place": "四川", "year": "2012" } ], "name": "mongodb"
     * }
     * 
     * @param customer
     * @return
     */
    @ApiOperation(value = "上传文档")
    @ApiImplicitParam(name = "customer", value = "保存的文档", paramType = "body", dataType = "Customer")
    @RequestMapping(value = "/save/customer", method = RequestMethod.PUT)
    public Customer save(@RequestBody Customer customer) {

        Customer c = repository.save(customer);
        return c;
    }

    // 查找(测试方法名查询)
    /**
     * 测试数据：mongodb
     * 
     * @param name
     * @return
     */
    @ApiOperation(value = "通过名称查找")
    @ApiImplicitParam(name = "name", value = "用户名称", required = true, paramType = "query", dataType = "String")
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public Customer findByName(@RequestParam(required = true) String name) {
        Customer c = repository.findByName(name);
        return c;
    }

    // 自定义查询通过年龄查询,测试@Query查询
    /**
     * 测试数据：age：33
     * 
     * @param age
     * @return
     */
    @ApiOperation(value = "通过年龄查找")
    @ApiImplicitParam(name = "age", value = "用户年龄", required = true, paramType = "query", dataType = "Integer")
    @RequestMapping(value = "/findByAge", method = RequestMethod.GET)
    public List<Customer> findByAge(@RequestParam(required = true) Integer age) {
        List<Customer> list = repository.withQueryFindByAge(age);
        return list;
    }
}
