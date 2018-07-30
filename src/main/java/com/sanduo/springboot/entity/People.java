package com.sanduo.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author sanduo
 * @date 2018/06/22
 */
@Entity(name = "person") // 和数据映射的实体类
@ApiModel(description = "人员")
public class People {

    @Id // 数据库的主键
    @GeneratedValue // 主键的生成方式自增，hibernate会生成一个Hibernate_sequence的序列
    @ApiModelProperty(value = "数据库主键")
    private Long id;

    @Column
    @ApiModelProperty(value = "数据库主键")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 
     */
    public People() {
        super();
    }

    /**
     * @param name
     * @param age
     * @param address
     */
    public People(String name, Integer age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * @param id
     * @param name
     * @param age
     * @param address
     */
    public People(Long id, String name, Integer age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /* toString
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
    }

}
