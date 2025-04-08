package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ShoushuDao;
import com.entity.ShoushuEntity;
import com.entity.view.ShoushuView;
import com.service.ShoushuService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 手术记录 服务实现类
 */
@Service("shoushuService")
@Transactional
public class ShoushuServiceImpl extends ServiceImpl<ShoushuDao, ShoushuEntity> implements ShoushuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShoushuView> page =new Query<ShoushuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
