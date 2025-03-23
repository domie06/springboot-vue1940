package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChekuEntity;
import java.util.Map;

/**
 * 洗衣机 服务类
 * @since 2021-03-16
 */
public interface ChekuService extends IService<ChekuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}