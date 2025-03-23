package com.entity.view;

import com.entity.ChekuzixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 房屋资讯
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-16
 */
@TableName("chekuzixun")
public class ChekuzixunView extends ChekuzixunEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ChekuzixunView() {

	}

	public ChekuzixunView(ChekuzixunEntity chekuzixunEntity) {
		try {
			BeanUtils.copyProperties(this, chekuzixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
