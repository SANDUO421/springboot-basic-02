package com.sanduo.springboot.repository;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.sanduo.springboot.entity.Employee;

/**
 * @author sanduo
 * @date 2018/07/30
 */
@Repository
public class EmployeeDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;// springboot已经配置了，此处直接注入

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOperations;// 基于字符串属性注入操作

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;// springboot已经配置了，此处直接注入

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> operations;

    public void stringRedisTemplateDemo() {// set 存储字符串类型
        valueOperations.set("sex", "男");
    }

    public void save(Employee employee) {// set 存储对象
        operations.set(employee.getId(), employee);
    }

    public String getString() {
        stringRedisTemplateDemo();
        return valueOperations.get("sex");
    }

    public Employee getEmployee() {
        return (Employee)operations.get("1");
    }

}
