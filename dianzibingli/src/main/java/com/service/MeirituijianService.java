package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.MeirituijianEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 每日推荐 服务类
 */
public interface MeirituijianService extends IService<MeirituijianEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}