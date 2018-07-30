package com.sanduo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanduo.springboot.entity.Employee;
import com.sanduo.springboot.repository.EmployeeDao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * rediscontroller
 * 
 * @author sanduo
 * @date 2018/07/30
 */
@Api(description = "reids 测试")
@RestController
public class RedisController {

    @Autowired
    EmployeeDao employeeDao;

    // 保存数据
    /**
     * 测试数据：{ "age": 26, "id": "1", "name": "sanduo" }
     * 
     * @param employee
     * @return
     */
    @ApiOperation(value = "保存数据")
    @ApiImplicitParam(name = "employee", value = "雇员", required = true, paramType = "body", dataType = "Employee")
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public String set(@RequestBody Employee employee) {

        employeeDao.save(employee);
        return "ok";
    }

    // 获取数据
    @ApiOperation(value = "获取字符串数据")
    @RequestMapping(value = "/getStr", method = RequestMethod.GET)
    public String getStr() {

        return employeeDao.getString();
    }

    // 获取对象
    @ApiOperation(value = "获取对象")
    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Employee getEmployee() {

        return employeeDao.getEmployee();
    }
}
