package com.sanduo.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建模板引擎的类 ， 2018/07/1添加了address，bootstrap+angularJs； 实战 正向工程实体类生成表
 * 
 * @author sanduo
 * @date 2018/06/22
 */
// @NamedQuery(name = "Person.findByAddress", query = "select p from person p where p.address=?1")
// @NamedQueries({@NamedQuery(name = "Person.findByAddress", query = "select p from person p where p.address=?1"),
// @NamedQuery(name = "Person.withNameAndAddressNamedQuery",
// query = "select p from person p where p.name=?1 and p.address=?2")})
@NamedQueries(@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
    query = "select p from Person p where p.name=?1 and p.address=?2"))
@Entity // 和数据映射的实体类
@ApiModel(description = "人员")
public class Person {

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
    public Person() {
        super();
    }

    /**
     * @param name
     * @param age
     * @param address
     */
    public Person(String name, Integer age, String address) {
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
    public Person(Long id, String name, Integer age, String address) {
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
