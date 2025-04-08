package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.XunxiDao;
import com.entity.XunxiEntity;
import com.entity.view.XunxiView;
import com.service.XunxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 医院讯息 服务实现类
 */
@Service("xunxiService")
@Transactional
public class XunxiServiceImpl extends ServiceImpl<XunxiDao, XunxiEntity> implements XunxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XunxiView> page =new Query<XunxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
