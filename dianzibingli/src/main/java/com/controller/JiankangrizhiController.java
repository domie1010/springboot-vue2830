package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiankangrizhiEntity;

import com.service.JiankangrizhiService;
import com.entity.view.JiankangrizhiView;
import com.service.HuanzheService;
import com.entity.HuanzheEntity;
import com.service.YishengService;
import com.entity.YishengEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 健康日记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankangrizhi")
public class JiankangrizhiController {
    private static final Logger logger = LoggerFactory.getLogger(JiankangrizhiController.class);

    @Autowired
    private JiankangrizhiService jiankangrizhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private HuanzheService huanzheService;
    @Autowired
    private YishengService yishengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
//        else if("医生".equals(role))
//            params.put("yishengId",request.getSession().getAttribute("userId"));
        else if("患者".equals(role))
            params.put("huanzheId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = jiankangrizhiService.queryPage(params);

        //字典表数据转换
        List<JiankangrizhiView> list =(List<JiankangrizhiView>)page.getList();
        for(JiankangrizhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangrizhiEntity jiankangrizhi = jiankangrizhiService.selectById(id);
        if(jiankangrizhi !=null){
            //entity转view
            JiankangrizhiView view = new JiankangrizhiView();
            BeanUtils.copyProperties( jiankangrizhi , view );//把实体数据重构到view中

            //级联表
            HuanzheEntity huanzhe = huanzheService.selectById(jiankangrizhi.getHuanzheId());
            if(huanzhe != null){
                BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setHuanzheId(huanzhe.getId());
            }
            //级联表
            YishengEntity yisheng = yishengService.selectById(jiankangrizhi.getYishengId());
            if(yisheng != null){
                BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYishengId(yisheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangrizhiEntity jiankangrizhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankangrizhi:{}",this.getClass().getName(),jiankangrizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            jiankangrizhi.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("医生".equals(role))
            jiankangrizhi.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<JiankangrizhiEntity> queryWrapper = new EntityWrapper<JiankangrizhiEntity>()
            .eq("huanzhe_id", jiankangrizhi.getHuanzheId())
            .eq("jiankangrizhi_time", jiankangrizhi.getJiankangrizhiTime())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangrizhiEntity jiankangrizhiEntity = jiankangrizhiService.selectOne(queryWrapper);
        if(jiankangrizhiEntity==null){
            jiankangrizhi.setInsertTime(new Date());
            jiankangrizhi.setCreateTime(new Date());
            jiankangrizhiService.insert(jiankangrizhi);
            return R.ok();
        }else {
            return R.error(511,"该患者今天已经有健康日记");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankangrizhiEntity jiankangrizhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiankangrizhi:{}",this.getClass().getName(),jiankangrizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            jiankangrizhi.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("医生".equals(role))
            jiankangrizhi.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiankangrizhiEntity> queryWrapper = new EntityWrapper<JiankangrizhiEntity>()
            .notIn("id",jiankangrizhi.getId())
            .andNew()
            .eq("huanzhe_id", jiankangrizhi.getHuanzheId())
            .eq("jiankangrizhi_time", jiankangrizhi.getJiankangrizhiTime())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangrizhiEntity jiankangrizhiEntity = jiankangrizhiService.selectOne(queryWrapper);
        if(jiankangrizhiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiankangrizhi.set
            //  }
            jiankangrizhiService.updateById(jiankangrizhi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该患者今天已经有健康日记");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiankangrizhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

