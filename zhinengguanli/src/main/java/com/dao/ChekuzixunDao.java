package com.dao;

import com.entity.ChekuzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChekuzixunView;

/**
 * 房屋资讯 Dao 接口
 *
 * @since 2021-03-16
 */
public interface ChekuzixunDao extends BaseMapper<ChekuzixunEntity> {

   List<ChekuzixunView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
