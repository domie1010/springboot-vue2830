package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.BingliEntity;
import com.entity.HuanzheEntity;
import com.entity.view.BingliView;
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
 * 病例
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bingli")
public class BingliController {
    private static final Logger logger = LoggerFactory.getLogger(BingliController.class);

    @Autowired
    private BingliService bingliService;


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
        PageUtils page = bingliService.queryPage(params);

        //字典表数据转换
        List<BingliView> list =(List<BingliView>)page.getList();
        for(BingliView c:list){
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
        BingliEntity bingli = bingliService.selectById(id);
        if(bingli !=null){
            //entity转view
            BingliView view = new BingliView();
            BeanUtils.copyProperties( bingli , view );//把实体数据重构到view中

            //级联表
            HuanzheEntity huanzhe = huanzheService.selectById(bingli.getHuanzheId());
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
    public R save(@RequestBody BingliEntity bingli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bingli:{}",this.getClass().getName(),bingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("医生".equals(role))
            bingli.setBingliYesonTypes(1);
        else if("患者".equals(role))
            bingli.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<BingliEntity> queryWrapper = new EntityWrapper<BingliEntity>()
            .eq("huanzhe_id", bingli.getHuanzheId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingliEntity bingliEntity = bingliService.selectOne(queryWrapper);
        if(bingliEntity==null){
            bingli.setCreateTime(new Date());
            bingliService.insert(bingli);
            return R.ok();
        }else {
            return R.error(511,"该患者已经有病例");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BingliEntity bingli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bingli:{}",this.getClass().getName(),bingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            bingli.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BingliEntity> queryWrapper = new EntityWrapper<BingliEntity>()
            .notIn("id",bingli.getId())
            .andNew()
            .eq("huanzhe_id", bingli.getHuanzheId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingliEntity bingliEntity = bingliService.selectOne(queryWrapper);
        if("".equals(bingli.getBingliFile()) || "null".equals(bingli.getBingliFile())){
                bingli.setBingliFile(null);
        }
        if(bingliEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      bingli.set
            //  }
            bingliService.updateById(bingli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该患者已经有病例");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        bingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

