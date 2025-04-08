package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.ShoushuEntity;
import com.entity.view.ShoushuView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 手术记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shoushu")
public class ShoushuController {
    private static final Logger logger = LoggerFactory.getLogger(ShoushuController.class);

    @Autowired
    private ShoushuService shoushuService;


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
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        else if("患者".equals(role))
            params.put("huanzheId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = shoushuService.queryPage(params);

        //字典表数据转换
        List<ShoushuView> list =(List<ShoushuView>)page.getList();
        for(ShoushuView c:list){
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
        ShoushuEntity shoushu = shoushuService.selectById(id);
        if(shoushu !=null){
            //entity转view
            ShoushuView view = new ShoushuView();
            BeanUtils.copyProperties( shoushu , view );//把实体数据重构到view中

            //级联表
            HuanzheEntity huanzhe = huanzheService.selectById(shoushu.getHuanzheId());
            if(huanzhe != null){
                BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setHuanzheId(huanzhe.getId());
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
    public R save(@RequestBody ShoushuEntity shoushu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shoushu:{}",this.getClass().getName(),shoushu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            shoushu.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        Wrapper<ShoushuEntity> queryWrapper = new EntityWrapper<ShoushuEntity>()
//            .eq("huanzhe_id", shoushu.getHuanzheId())
//            .eq("shoushu_name", shoushu.getShoushuName())
//            .eq("shoushu_types", shoushu.getShoushuTypes())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        ShoushuEntity shoushuEntity = shoushuService.selectOne(queryWrapper);
//        if(shoushuEntity==null){
            shoushu.setCreateTime(new Date());
            shoushuService.insert(shoushu);
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShoushuEntity shoushu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shoushu:{}",this.getClass().getName(),shoushu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            shoushu.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        //根据字段查询是否有相同数据
//        Wrapper<ShoushuEntity> queryWrapper = new EntityWrapper<ShoushuEntity>()
//            .notIn("id",shoushu.getId())
//            .andNew()
//            .eq("huanzhe_id", shoushu.getHuanzheId())
//            .eq("shoushu_name", shoushu.getShoushuName())
//            .eq("shoushu_types", shoushu.getShoushuTypes())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        ShoushuEntity shoushuEntity = shoushuService.selectOne(queryWrapper);
//        if(shoushuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shoushu.set
            //  }
            shoushuService.updateById(shoushu);//根据id更新
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shoushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

