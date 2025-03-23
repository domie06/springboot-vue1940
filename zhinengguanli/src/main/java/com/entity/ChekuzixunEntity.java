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
 * 房屋资讯
 *
 * @email
 * @date 2021-03-16
 */
@TableName("chekuzixun")
public class ChekuzixunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ChekuzixunEntity() {

    }

    public ChekuzixunEntity(T t) {
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
    private Long id;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "addtime")

    private Date addtime;


    /**
     * 资讯标题
     */
    @TableField(value = "zixunbiaoti")

    private String zixunbiaoti;


    /**
     * 封面图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fabushijian")

    private Date fabushijian;


    /**
     * 发布人
     */
    @TableField(value = "faburen")

    private String faburen;


    /**
     * 文章来源
     */
    @TableField(value = "wenzhanglaiyuan")

    private String wenzhanglaiyuan;


    /**
     * 资讯内容
     */
    @TableField(value = "zixunneirong_content")

    private String zixunneirongContent;


    /**
	 * 设置：主键
	 */
    public Long getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Long id) {
        this.id = id;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getAddtime() {
        return addtime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
    /**
	 * 设置：资讯标题
	 */
    public String getZixunbiaoti() {
        return zixunbiaoti;
    }


    /**
	 * 获取：资讯标题
	 */

    public void setZixunbiaoti(String zixunbiaoti) {
        this.zixunbiaoti = zixunbiaoti;
    }
    /**
	 * 设置：封面图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：封面图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getFabushijian() {
        return fabushijian;
    }


    /**
	 * 获取：发布时间
	 */

    public void setFabushijian(Date fabushijian) {
        this.fabushijian = fabushijian;
    }
    /**
	 * 设置：发布人
	 */
    public String getFaburen() {
        return faburen;
    }


    /**
	 * 获取：发布人
	 */

    public void setFaburen(String faburen) {
        this.faburen = faburen;
    }
    /**
	 * 设置：文章来源
	 */
    public String getWenzhanglaiyuan() {
        return wenzhanglaiyuan;
    }


    /**
	 * 获取：文章来源
	 */

    public void setWenzhanglaiyuan(String wenzhanglaiyuan) {
        this.wenzhanglaiyuan = wenzhanglaiyuan;
    }
    /**
	 * 设置：资讯内容
	 */
    public String getZixunneirongContent() {
        return zixunneirongContent;
    }


    /**
	 * 获取：资讯内容
	 */

    public void setZixunneirongContent(String zixunneirongContent) {
        this.zixunneirongContent = zixunneirongContent;
    }

    @Override
    public String toString() {
    return "Chekuzixun{" +
            "id=" + id +
            ", addtime=" + addtime +
            ", zixunbiaoti=" + zixunbiaoti +
            ", imgPhoto=" + imgPhoto +
            ", fabushijian=" + fabushijian +
            ", faburen=" + faburen +
            ", wenzhanglaiyuan=" + wenzhanglaiyuan +
            ", zixunneirongContent=" + zixunneirongContent +
    "}";
    }
    }
