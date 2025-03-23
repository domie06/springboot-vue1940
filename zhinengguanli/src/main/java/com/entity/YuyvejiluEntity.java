package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 预约记录
 *
 * @email
 * @date 2021-03-16
 */
@TableName("yuyvejilu")
public class YuyvejiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YuyvejiluEntity() {

    }

    public YuyvejiluEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 车库id
     */
    @TableField(value = "ck_types")
    private Integer ckTypes;
    /**
     * 车库id
     */
    @TableField(value = "dayMax")
    private Integer dayMax;

    public Integer getDayMax() {
        return dayMax;
    }

    public void setDayMax(Integer dayMax) {
        this.dayMax = dayMax;
    }

    /**
     * 预约用户
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 车库主人
     */
    @TableField(value = "ry_types")

    private Integer ryTypes;


    /**
     * 车库位置
     */
    @TableField(value = "location")

    private String location;


    /**
     * 预约开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy年MM月dd日 HH点")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
     * 预约时长（单位小时）
     */
    @TableField(value = "day")

    private Integer day;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：车库id
	 */
    public Integer getCkTypes() {
        return ckTypes;
    }


    /**
	 * 获取：车库id
	 */

    public void setCkTypes(Integer ckTypes) {
        this.ckTypes = ckTypes;
    }
    /**
	 * 设置：预约用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：预约用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：车库主人
	 */
    public Integer getRyTypes() {
        return ryTypes;
    }


    /**
	 * 获取：车库主人
	 */

    public void setRyTypes(Integer ryTypes) {
        this.ryTypes = ryTypes;
    }
    /**
	 * 设置：车库位置
	 */
    public String getLocation() {
        return location;
    }


    /**
	 * 获取：车库位置
	 */

    public void setLocation(String location) {
        this.location = location;
    }
    /**
	 * 设置：预约开始时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预约开始时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：预约时长（单位小时）
	 */
    public Integer getDay() {
        return day;
    }


    /**
	 * 获取：预约时长（单位小时）
	 */

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
    return "Yuyvejilu{" +
            "id=" + id +
            ", ckTypes=" + ckTypes +
            ", yhTypes=" + yhTypes +
            ", ryTypes=" + ryTypes +
            ", location=" + location +
            ", createTime=" + createTime +
            ", day=" + day +
    "}";
    }
    }
