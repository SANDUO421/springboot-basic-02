package com.sanduo.springboot.entity;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建领域模型--mongodb
 * 
 * @author sanduo
 * @date 2018/07/27
 */
@ApiModel(description = "mongodb文档")
@Document // object模型和Document映射
public class Customer {

    @Id
    @ApiModelProperty(value = "文档id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Field(value = "locs") // 此属性在文档中的名称，locations将以数组的形式存储当前数据记录
    @ApiModelProperty(value = "存储记录数据")
    private Collection<Location> locations = new LinkedHashSet<Location>();

    /**
     * 
     */
    public Customer() {
        super();
    }

    /**
     * @param name
     * @param age
     */
    public Customer(String name, Integer age) {
        super();
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

    /**
     * @return the locations
     */
    public Collection<Location> getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

}
