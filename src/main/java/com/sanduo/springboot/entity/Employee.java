package com.sanduo.springboot.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * redis测试
 * 
 * @author sanduo
 * @date 2018/07/30
 */
@ApiModel(description = "redis测试模型类")
public class Employee implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1484039145709328349L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 使用jackSon序列化必须要有空构造
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @param name
     * @param age
     */
    public Employee(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

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
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

}
