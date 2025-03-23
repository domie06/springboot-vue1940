package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ChekuDao;
import com.entity.ChekuEntity;
import com.service.ChekuService;
import com.entity.view.ChekuView;

/**
 * 洗衣机 服务实现类
 * @since 2021-03-16
 */
@Service("chekuService")
@Transactional
public class ChekuServiceImpl extends ServiceImpl<ChekuDao, ChekuEntity> implements ChekuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChekuView> page =new Query<ChekuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
