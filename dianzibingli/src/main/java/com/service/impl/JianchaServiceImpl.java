package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.JianchaDao;
import com.entity.JianchaEntity;
import com.entity.view.JianchaView;
import com.service.JianchaService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 检查记录 服务实现类
 */
@Service("jianchaService")
@Transactional
public class JianchaServiceImpl extends ServiceImpl<JianchaDao, JianchaEntity> implements JianchaService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JianchaView> page =new Query<JianchaView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
