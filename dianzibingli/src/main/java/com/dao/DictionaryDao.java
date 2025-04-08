package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DictionaryEntity;
import com.entity.view.DictionaryView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典表 Dao 接口
 *
 * @author 
 */
public interface DictionaryDao extends BaseMapper<DictionaryEntity> {

   List<DictionaryView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
