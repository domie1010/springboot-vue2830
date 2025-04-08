package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.BingliEntity;
import com.entity.view.BingliView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 病例 Dao 接口
 *
 * @author 
 */
public interface BingliDao extends BaseMapper<BingliEntity> {

   List<BingliView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
