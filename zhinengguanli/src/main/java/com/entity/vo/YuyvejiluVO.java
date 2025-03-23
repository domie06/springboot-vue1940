package com.entity.vo;

import com.entity.YuyvejiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-16
 */
@TableName("yuyvejilu")
public class YuyvejiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车库id Search
     */

    @TableField(value = "ck_types")
    private Integer ckTypes;


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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
