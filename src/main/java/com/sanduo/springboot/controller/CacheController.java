package com.sanduo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanduo.springboot.entity.Person;
import com.sanduo.springboot.service.CacheService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * cache Controller
 * 
 * @author sanduo
 * @date 2018/07/27
 */
@RestController
@Api(description = "对people数据缓存处理")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    /**
     * 保存缓存
     * 
     * @param person
     * @return
     */
    @ApiOperation(value = "保存缓存")
    @ApiImplicitParam(name = "person", value = "缓存的对象", required = true, paramType = "body", dataType = "Person")
    @RequestMapping(value = "/save/cache", method = RequestMethod.PUT)
    public Person save(@RequestBody Person person) {
        Person p = cacheService.save(person);
        return p;
    }

    /**
     * 移除
     * 
     * @param id
     * @return
     */
    @ApiOperation(value = "清除缓存")
    @ApiImplicitParam(name = "id", value = "清楚的缓存id", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable(name = "id", required = true) Long id) {
        cacheService.remove(id);
        return "删除成功";
    }

    @ApiOperation(value = "查询缓存")
    @ApiImplicitParam(name = "person", value = "查询的缓存对象", required = true, paramType = "body", dataType = "Person")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Person findById(@RequestBody Person person) {
        return cacheService.findOne(person);
    }
}
