package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyvejiluEntity;
import java.util.Map;

/**
 * 预约记录 服务类
 * @since 2021-03-16
 */
public interface YuyvejiluService extends IService<YuyvejiluEntity> {

     PageUtils queryPage(Map<String, Object> params);

}