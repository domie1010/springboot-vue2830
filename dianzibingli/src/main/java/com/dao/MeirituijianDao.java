package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MeirituijianEntity;
import com.entity.view.MeirituijianView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 每日推荐 Dao 接口
 *
 * @author 
 */
public interface MeirituijianDao extends BaseMapper<MeirituijianEntity> {

   List<MeirituijianView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
