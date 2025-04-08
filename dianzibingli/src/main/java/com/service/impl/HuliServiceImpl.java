package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.HuliDao;
import com.entity.HuliEntity;
import com.entity.view.HuliView;
import com.service.HuliService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 护理记录 服务实现类
 */
@Service("huliService")
@Transactional
public class HuliServiceImpl extends ServiceImpl<HuliDao, HuliEntity> implements HuliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HuliView> page =new Query<HuliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
