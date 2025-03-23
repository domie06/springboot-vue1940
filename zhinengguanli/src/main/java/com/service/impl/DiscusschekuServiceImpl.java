package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusschekuDao;
import com.entity.DiscusschekuEntity;
import com.service.DiscusschekuService;
import com.entity.vo.DiscusschekuVO;
import com.entity.view.DiscusschekuView;

@Service("discusschekuService")
public class DiscusschekuServiceImpl extends ServiceImpl<DiscusschekuDao, DiscusschekuEntity> implements DiscusschekuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschekuEntity> page = this.selectPage(
                new Query<DiscusschekuEntity>(params).getPage(),
                new EntityWrapper<DiscusschekuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschekuEntity> wrapper) {
		  Page<DiscusschekuView> page =new Query<DiscusschekuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusschekuVO> selectListVO(Wrapper<DiscusschekuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschekuVO selectVO(Wrapper<DiscusschekuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschekuView> selectListView(Wrapper<DiscusschekuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschekuView selectView(Wrapper<DiscusschekuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
