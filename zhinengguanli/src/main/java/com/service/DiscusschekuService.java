package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschekuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschekuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschekuView;


/**
 * 车库评论表
 *
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
public interface DiscusschekuService extends IService<DiscusschekuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschekuVO> selectListVO(Wrapper<DiscusschekuEntity> wrapper);
   	
   	DiscusschekuVO selectVO(@Param("ew") Wrapper<DiscusschekuEntity> wrapper);
   	
   	List<DiscusschekuView> selectListView(Wrapper<DiscusschekuEntity> wrapper);
   	
   	DiscusschekuView selectView(@Param("ew") Wrapper<DiscusschekuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschekuEntity> wrapper);
   	
}

