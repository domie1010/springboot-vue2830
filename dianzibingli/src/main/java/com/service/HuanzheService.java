package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.HuanzheEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 患者 服务类
 */
public interface HuanzheService extends IService<HuanzheEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}