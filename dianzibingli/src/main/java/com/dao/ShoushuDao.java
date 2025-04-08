package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ShoushuEntity;
import com.entity.view.ShoushuView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 手术记录 Dao 接口
 *
 * @author 
 */
public interface ShoushuDao extends BaseMapper<ShoushuEntity> {

   List<ShoushuView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
