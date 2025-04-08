package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YizhuDao;
import com.entity.YizhuEntity;
import com.entity.view.YizhuView;
import com.service.YizhuService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 医嘱 服务实现类
 */
@Service("yizhuService")
@Transactional
public class YizhuServiceImpl extends ServiceImpl<YizhuDao, YizhuEntity> implements YizhuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YizhuView> page =new Query<YizhuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
