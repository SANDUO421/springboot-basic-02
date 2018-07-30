package com.sanduo.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 记录
 * 
 * @author sanduo
 * @date 2018/07/27
 */
@ApiModel(description = "记录表映射实体类")
public class Location {

    @ApiModelProperty(value = "存储地点")
    private String place;

    @ApiModelProperty(value = "存储年月")
    private String year;

    /**
     * 
     */
    public Location() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param place
     * @param year
     */
    public Location(String place, String year) {
        super();
        this.place = place;
        this.year = year;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

}
