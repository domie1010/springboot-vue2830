package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.XunxiEntity;
import com.entity.view.XunxiView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 医院讯息 Dao 接口
 *
 * @author 
 */
public interface XunxiDao extends BaseMapper<XunxiEntity> {

   List<XunxiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
