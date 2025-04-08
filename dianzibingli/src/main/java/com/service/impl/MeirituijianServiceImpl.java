package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MeirituijianDao;
import com.entity.MeirituijianEntity;
import com.entity.view.MeirituijianView;
import com.service.MeirituijianService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 每日推荐 服务实现类
 */
@Service("meirituijianService")
@Transactional
public class MeirituijianServiceImpl extends ServiceImpl<MeirituijianDao, MeirituijianEntity> implements MeirituijianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<MeirituijianView> page =new Query<MeirituijianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
