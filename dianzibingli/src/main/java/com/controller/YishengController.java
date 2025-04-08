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

import com.entity.YishengEntity;

import com.service.YishengService;
import com.entity.view.YishengView;
import com.service.HuanzheService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 医生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yisheng")
public class YishengController {
    private static final Logger logger = LoggerFactory.getLogger(YishengController.class);

    @Autowired
    private YishengService yishengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = yishengService.queryPage(params);

        //字典表数据转换
        List<YishengView> list =(List<YishengView>)page.getList();
        for(YishengView c:list){
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
        YishengEntity yisheng = yishengService.selectById(id);
        if(yisheng !=null){
            //entity转view
            YishengView view = new YishengView();
            BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中

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
    public R save(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .eq("username", yisheng.getUsername())
            .or()
            .eq("yisheng_phone", yisheng.getYishengPhone())
            .or()
            .eq("yisheng_id_number", yisheng.getYishengIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if(yishengEntity==null){
            yisheng.setCreateTime(new Date());
            yisheng.setPassword("123456");
            yishengService.insert(yisheng);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .notIn("id",yisheng.getId())
            .andNew()
            .eq("username", yisheng.getUsername())
            .or()
            .eq("yisheng_phone", yisheng.getYishengPhone())
            .or()
            .eq("yisheng_id_number", yisheng.getYishengIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if("".equals(yisheng.getYishengPhoto()) || "null".equals(yisheng.getYishengPhoto())){
                yisheng.setYishengPhoto(null);
        }
        if(yishengEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yisheng.set
            //  }
            yishengService.updateById(yisheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YishengEntity yisheng = yishengService.selectOne(new EntityWrapper<YishengEntity>().eq("username", username));
        if(yisheng==null || !yisheng.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(yisheng.getId(),username, "yisheng", "医生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","医生");
        r.put("username",yisheng.getYishengName());
        r.put("tableName","yisheng");
        r.put("userId",yisheng.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YishengEntity yisheng){
    //    	ValidatorUtils.validateEntity(user);
        if(yishengService.selectOne(new EntityWrapper<YishengEntity>().eq("username", yisheng.getUsername()).orNew().eq("yisheng_phone",yisheng.getYishengPhone()).orNew().eq("yisheng_id_number",yisheng.getYishengIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        yisheng.setCreateTime(new Date());
        yishengService.insert(yisheng);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        YishengEntity yisheng = new YishengEntity();
        yisheng.setPassword("123456");
        yisheng.setId(id);
        yishengService.updateById(yisheng);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYisheng(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YishengEntity yisheng = yishengService.selectById(id);
        if(yisheng !=null){
            //entity转view
            YishengView view = new YishengView();
            BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

