package com.entity.view;

import com.entity.DiscusschekuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 车库评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
@TableName("discusscheku")
public class DiscusschekuView extends DiscusschekuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusschekuView(){
	}
 
 	public DiscusschekuView(DiscusschekuEntity discusschekuEntity){
 	try {
			BeanUtils.copyProperties(this, discusschekuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
