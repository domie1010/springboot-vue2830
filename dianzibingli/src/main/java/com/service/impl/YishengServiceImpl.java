package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YishengDao;
import com.entity.YishengEntity;
import com.entity.view.YishengView;
import com.service.YishengService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 医生 服务实现类
 */
@Service("yishengService")
@Transactional
public class YishengServiceImpl extends ServiceImpl<YishengDao, YishengEntity> implements YishengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YishengView> page =new Query<YishengView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
