package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.HuliEntity;
import com.entity.view.HuliView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 护理记录 Dao 接口
 *
 * @author 
 */
public interface HuliDao extends BaseMapper<HuliEntity> {

   List<HuliView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
