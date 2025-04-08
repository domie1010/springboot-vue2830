package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YishengEntity;
import com.entity.view.YishengView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 医生 Dao 接口
 *
 * @author 
 */
public interface YishengDao extends BaseMapper<YishengEntity> {

   List<YishengView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
