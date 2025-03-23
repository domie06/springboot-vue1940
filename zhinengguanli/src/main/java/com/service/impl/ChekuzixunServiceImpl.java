package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ChekuzixunDao;
import com.entity.ChekuzixunEntity;
import com.service.ChekuzixunService;
import com.entity.view.ChekuzixunView;

/**
 * 房屋资讯 服务实现类
 * @since 2021-03-16
 */
@Service("chekuzixunService")
@Transactional
public class ChekuzixunServiceImpl extends ServiceImpl<ChekuzixunDao, ChekuzixunEntity> implements ChekuzixunService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChekuzixunView> page =new Query<ChekuzixunView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
