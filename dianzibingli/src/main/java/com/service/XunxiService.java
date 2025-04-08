package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.XunxiEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 医院讯息 服务类
 */
public interface XunxiService extends IService<XunxiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}