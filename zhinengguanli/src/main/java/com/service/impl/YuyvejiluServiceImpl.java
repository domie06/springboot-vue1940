package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.YuyvejiluDao;
import com.entity.YuyvejiluEntity;
import com.service.YuyvejiluService;
import com.entity.view.YuyvejiluView;

/**
 * 预约记录 服务实现类
 * @since 2021-03-16
 */
@Service("yuyvejiluService")
@Transactional
public class YuyvejiluServiceImpl extends ServiceImpl<YuyvejiluDao, YuyvejiluEntity> implements YuyvejiluService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YuyvejiluView> page =new Query<YuyvejiluView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
