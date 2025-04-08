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

import com.entity.MeirituijianEntity;

import com.service.MeirituijianService;
import com.entity.view.MeirituijianView;
import com.service.YishengService;
import com.service.HuanzheService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 每日推荐
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirituijian")
public class MeirituijianController {
    private static final Logger logger = LoggerFactory.getLogger(MeirituijianController.class);

    @Autowired
    private MeirituijianService meirituijianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YishengService yishengService;
    @Autowired
    private HuanzheService huanzheService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        else if("患者".equals(role))
            params.put("huanzheId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = meirituijianService.queryPage(params);

        //字典表数据转换
        List<MeirituijianView> list =(List<MeirituijianView>)page.getList();
        for(MeirituijianView c:list){
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
        MeirituijianEntity meirituijian = meirituijianService.selectById(id);
        if(meirituijian !=null){
            //entity转view
            MeirituijianView view = new MeirituijianView();
            BeanUtils.copyProperties( meirituijian , view );//把实体数据重构到view中

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
    public R save(@RequestBody MeirituijianEntity meirituijian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirituijian:{}",this.getClass().getName(),meirituijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<MeirituijianEntity> queryWrapper = new EntityWrapper<MeirituijianEntity>()
            .eq("meirituijian_name", meirituijian.getMeirituijianName())
            .eq("meirituijian_time", meirituijian.getMeirituijianTime())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirituijianEntity meirituijianEntity = meirituijianService.selectOne(queryWrapper);
        if(meirituijianEntity==null){
            meirituijian.setInsertTime(new Date());
            meirituijian.setCreateTime(new Date());
            meirituijianService.insert(meirituijian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirituijianEntity meirituijian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,meirituijian:{}",this.getClass().getName(),meirituijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<MeirituijianEntity> queryWrapper = new EntityWrapper<MeirituijianEntity>()
            .notIn("id",meirituijian.getId())
            .andNew()
            .eq("meirituijian_name", meirituijian.getMeirituijianName())
            .eq("meirituijian_time", meirituijian.getMeirituijianTime())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirituijianEntity meirituijianEntity = meirituijianService.selectOne(queryWrapper);
        if(meirituijianEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      meirituijian.set
            //  }
            meirituijianService.updateById(meirituijian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        meirituijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

