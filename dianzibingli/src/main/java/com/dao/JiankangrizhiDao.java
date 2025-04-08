package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.JiankangrizhiEntity;
import com.entity.view.JiankangrizhiView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 健康日记 Dao 接口
 *
 * @author 
 */
public interface JiankangrizhiDao extends BaseMapper<JiankangrizhiEntity> {

   List<JiankangrizhiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
