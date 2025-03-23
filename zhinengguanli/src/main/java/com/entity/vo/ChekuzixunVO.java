package com.entity.vo;

import com.entity.ChekuzixunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋资讯
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-16
 */
@TableName("chekuzixun")
public class ChekuzixunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 资讯标题 Search
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
	 * 设置：资讯标题 Search
	 */
    public String getZixunbiaoti() {
        return zixunbiaoti;
    }


    /**
	 * 获取：资讯标题 Search
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

}
