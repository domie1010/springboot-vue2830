package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.HuanzheDao;
import com.entity.HuanzheEntity;
import com.entity.view.HuanzheView;
import com.service.HuanzheService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 患者 服务实现类
 */
@Service("huanzheService")
@Transactional
public class HuanzheServiceImpl extends ServiceImpl<HuanzheDao, HuanzheEntity> implements HuanzheService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HuanzheView> page =new Query<HuanzheView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
