package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.JianchaEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 检查记录 服务类
 */
public interface JianchaService extends IService<JianchaEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}