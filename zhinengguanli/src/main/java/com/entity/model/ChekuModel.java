package com.entity.model;

import com.entity.ChekuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 洗衣机
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-16
 */
public class ChekuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车库名称 Search
     */
    private String name;


    /**
     * 车库位置
     */
    private String location;


    /**
     * 车库主人
     */
    private Integer ryTypes;


    /**
     * 车库大小
     */
    private String garageSize;


    /**
     * 车库价格(天)
     */
    private Integer money;


    /**
     * 车库状态
     */
    private Integer ckztTypes;


    /**
     * 车库图片
     */
    private String imgPhoto;


    /**
     * 车库内容
     */
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
	 * 设置：车库名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：车库名称 Search
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

    }
