package com.entity.model;

import com.entity.YuyvejiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-16
 */
public class YuyvejiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车库id Search
     */
    private Integer ckTypes;


    /**
     * 预约用户
     */
    private Integer yhTypes;


    /**
     * 车库主人
     */
    private Integer ryTypes;


    /**
     * 车库位置
     */
    private String location;


    /**
     * 预约开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
     * 预约时长（单位小时）
     */
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
	 * 设置：车库id Search
	 */
    public Integer getCkTypes() {
        return ckTypes;
    }


    /**
	 * 获取：车库id Search
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

    }
