package com.sanduo.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者类
 * 
 * @author sanduo
 * @date 2018/06/04
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSetting {

    private String name;
    private Long age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Long getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Long age) {
        this.age = age;
    }

}
