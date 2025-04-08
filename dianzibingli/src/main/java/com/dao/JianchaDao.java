package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.JianchaEntity;
import com.entity.view.JianchaView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 检查记录 Dao 接口
 *
 * @author 
 */
public interface JianchaDao extends BaseMapper<JianchaEntity> {

   List<JianchaView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
