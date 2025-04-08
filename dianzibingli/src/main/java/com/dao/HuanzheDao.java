package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.HuanzheEntity;
import com.entity.view.HuanzheView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 患者 Dao 接口
 *
 * @author 
 */
public interface HuanzheDao extends BaseMapper<HuanzheEntity> {

   List<HuanzheView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
