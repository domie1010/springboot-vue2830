package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.BingliDao;
import com.entity.BingliEntity;
import com.entity.view.BingliView;
import com.service.BingliService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 病例 服务实现类
 */
@Service("bingliService")
@Transactional
public class BingliServiceImpl extends ServiceImpl<BingliDao, BingliEntity> implements BingliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<BingliView> page =new Query<BingliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
