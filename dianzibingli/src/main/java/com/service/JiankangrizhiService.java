package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.JiankangrizhiEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 健康日记 服务类
 */
public interface JiankangrizhiService extends IService<JiankangrizhiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}