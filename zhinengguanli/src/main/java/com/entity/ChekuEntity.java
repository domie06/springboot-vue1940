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
 * 洗衣机
 *
 * @email
 * @date 2021-03-16
 */
@TableName("cheku")
public class ChekuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ChekuEntity() {

    }

    public ChekuEntity(T t) {
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
     * 车库名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 车库位置
     */
    @TableField(value = "location")

    private String location;


    /**
     * 车库主人
     */
    @TableField(value = "ry_types")

    private Integer ryTypes;


    /**
     * 车库大小
     */
    @TableField(value = "garageSize")

    private String garageSize;


    /**
     * 车库价格(天)
     */
    @TableField(value = "money")

    private Integer money;


    /**
     * 车库状态
     */
    @TableField(value = "ckzt_types")

    private Integer ckztTypes;
    /**
     * 车库状态
     */
    @TableField(value = "thumbsupnum")

    private Integer thumbsupnum;
    /**
     * 车库状态
     */
    @TableField(value = "crazilynum")

    private Integer crazilynum;

    public Integer getThumbsupnum() {
        return thumbsupnum;
    }

    public void setThumbsupnum(Integer thumbsupnum) {
        this.thumbsupnum = thumbsupnum;
    }

    public Integer getCrazilynum() {
        return crazilynum;
    }

    public void setCrazilynum(Integer crazilynum) {
        this.crazilynum = crazilynum;
    }

    /**
     * 车库图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 车库内容
     */
    @TableField(value = "matter_content")

    private String matterContent;


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
	 * 设置：车库名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：车库名称
	 */

    public void setName(String name) {
        this.name = name;
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
	 * 设置：车库大小
	 */
    public String getGarageSize() {
        return garageSize;
    }


    /**
	 * 获取：车库大小
	 */

    public void setGarageSize(String garageSize) {
        this.garageSize = garageSize;
    }
    /**
	 * 设置：车库价格(天)
	 */
    public Integer getMoney() {
        return money;
    }


    /**
	 * 获取：车库价格(天)
	 */

    public void setMoney(Integer money) {
        this.money = money;
    }
    /**
	 * 设置：车库状态
	 */
    public Integer getCkztTypes() {
        return ckztTypes;
    }


    /**
	 * 获取：车库状态
	 */

    public void setCkztTypes(Integer ckztTypes) {
        this.ckztTypes = ckztTypes;
    }
    /**
	 * 设置：车库图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：车库图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：车库内容
	 */
    public String getMatterContent() {
        return matterContent;
    }


    /**
	 * 获取：车库内容
	 */

    public void setMatterContent(String matterContent) {
        this.matterContent = matterContent;
    }

    @Override
    public String toString() {
    return "Cheku{" +
            "id=" + id +
            ", name=" + name +
            ", location=" + location +
            ", ryTypes=" + ryTypes +
            ", garageSize=" + garageSize +
            ", money=" + money +
            ", ckztTypes=" + ckztTypes +
            ", imgPhoto=" + imgPhoto +
            ", matterContent=" + matterContent +
    "}";
    }
    }
