package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.JiankangrizhiDao;
import com.entity.JiankangrizhiEntity;
import com.entity.view.JiankangrizhiView;
import com.service.JiankangrizhiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 健康日记 服务实现类
 */
@Service("jiankangrizhiService")
@Transactional
public class JiankangrizhiServiceImpl extends ServiceImpl<JiankangrizhiDao, JiankangrizhiEntity> implements JiankangrizhiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiankangrizhiView> page =new Query<JiankangrizhiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
