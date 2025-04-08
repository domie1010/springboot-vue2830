package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YizhuEntity;
import com.entity.view.YizhuView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 医嘱 Dao 接口
 *
 * @author 
 */
public interface YizhuDao extends BaseMapper<YizhuEntity> {

   List<YizhuView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
