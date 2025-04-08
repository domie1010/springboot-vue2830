package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.HuliEntity;
import com.entity.view.HuliView;
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
 * 护理记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huli")
public class HuliController {
    private static final Logger logger = LoggerFactory.getLogger(HuliController.class);

    @Autowired
    private HuliService huliService;


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
        PageUtils page = huliService.queryPage(params);

        //字典表数据转换
        List<HuliView> list =(List<HuliView>)page.getList();
        for(HuliView c:list){
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
        HuliEntity huli = huliService.selectById(id);
        if(huli !=null){
            //entity转view
            HuliView view = new HuliView();
            BeanUtils.copyProperties( huli , view );//把实体数据重构到view中

            //级联表
            HuanzheEntity huanzhe = huanzheService.selectById(huli.getHuanzheId());
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
    public R save(@RequestBody HuliEntity huli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huli:{}",this.getClass().getName(),huli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            huli.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        Wrapper<HuliEntity> queryWrapper = new EntityWrapper<HuliEntity>()
//            .eq("huanzhe_id", huli.getHuanzheId())
//            .eq("huli_name", huli.getHuliName())
//            .eq("huli_types", huli.getHuliTypes())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        HuliEntity huliEntity = huliService.selectOne(queryWrapper);
//        if(huliEntity==null){
            huli.setCreateTime(new Date());
            huliService.insert(huli);
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuliEntity huli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huli:{}",this.getClass().getName(),huli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("患者".equals(role))
            huli.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HuliEntity> queryWrapper = new EntityWrapper<HuliEntity>()
            .notIn("id",huli.getId())
            .andNew()
            .eq("huanzhe_id", huli.getHuanzheId())
            .eq("huli_name", huli.getHuliName())
            .eq("huli_types", huli.getHuliTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuliEntity huliEntity = huliService.selectOne(queryWrapper);
        if(huliEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      huli.set
            //  }
            huliService.updateById(huli);//根据id更新
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
        huliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

