package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChekuzixunEntity;
import java.util.Map;

/**
 * 房屋资讯 服务类
 * @since 2021-03-16
 */
public interface ChekuzixunService extends IService<ChekuzixunEntity> {

     PageUtils queryPage(Map<String, Object> params);

}