package com.dao;

import com.entity.DiscusschekuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschekuVO;
import com.entity.view.DiscusschekuView;


/**
 * 车库评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
public interface DiscusschekuDao extends BaseMapper<DiscusschekuEntity> {
	
	List<DiscusschekuVO> selectListVO(@Param("ew") Wrapper<DiscusschekuEntity> wrapper);
	
	DiscusschekuVO selectVO(@Param("ew") Wrapper<DiscusschekuEntity> wrapper);
	
	List<DiscusschekuView> selectListView(@Param("ew") Wrapper<DiscusschekuEntity> wrapper);

	List<DiscusschekuView> selectListView(Pagination page, @Param("ew") Wrapper<DiscusschekuEntity> wrapper);
	
	DiscusschekuView selectView(@Param("ew") Wrapper<DiscusschekuEntity> wrapper);
	
}
