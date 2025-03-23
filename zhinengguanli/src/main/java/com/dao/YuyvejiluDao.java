package com.dao;

import com.entity.YuyvejiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyvejiluView;

/**
 * 预约记录 Dao 接口
 *
 * @since 2021-03-16
 */
public interface YuyvejiluDao extends BaseMapper<YuyvejiluEntity> {

   List<YuyvejiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
