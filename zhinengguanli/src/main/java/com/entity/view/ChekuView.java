package com.entity.view;

import com.entity.ChekuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 洗衣机
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-16
 */
@TableName("cheku")
public class ChekuView extends ChekuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ChekuView() {

	}

	public ChekuView(ChekuEntity chekuEntity) {
		try {
			BeanUtils.copyProperties(this, chekuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
