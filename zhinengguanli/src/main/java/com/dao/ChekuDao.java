package com.dao;

import com.entity.ChekuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChekuView;

/**
 * 洗衣机 Dao 接口
 *
 * @since 2021-03-16
 */
public interface ChekuDao extends BaseMapper<ChekuEntity> {

   List<ChekuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
