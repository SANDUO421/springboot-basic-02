package com.sanduo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanduo.springboot.entity.Person;
import com.sanduo.springboot.service.TransactionPersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 事务Controller
 * 
 * @author sanduo
 * @date 2018/07/26
 */
@Api(description = "事务测试controller")
@RestController
public class TransactionController {

    @Autowired
    private TransactionPersonService transactionPersonService;

    @ApiOperation(value = "保存回滚测试", notes = "保存用户，当出现某个异常，事务回滚")
    @ApiImplicitParam(name = "person", value = "保存的用户", required = true, paramType = "body", dataType = "Person")
    @RequestMapping(value = "/rollback", method = RequestMethod.PUT)
    public Person rollback(@RequestBody Person person) {
        Person result = transactionPersonService.savePersonWithRollBack(person);
        if (result != null) {
            return result;
        }
        return null;
    }

    @ApiOperation(value = "保存不回滚测试", notes = "保存用户，当出现某个异常，事务回滚")
    @ApiImplicitParam(name = "person", value = "保存的用户", required = true, paramType = "body", dataType = "Person")
    @RequestMapping(value = "/noRollback", method = RequestMethod.PUT)
    public Person noRollback(@RequestBody Person person) {
        Person result = transactionPersonService.savePersonWithnoRollBack(person);
        if (result != null) {
            return result;
        }
        return null;
    }
}
