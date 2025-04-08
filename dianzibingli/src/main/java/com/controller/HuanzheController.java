package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.view.HuanzheView;
import com.service.DictionaryService;
import com.service.HuanzheService;
import com.service.TokenService;
import com.service.YishengService;
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
 * 患者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huanzhe")
public class HuanzheController {
    private static final Logger logger = LoggerFactory.getLogger(HuanzheController.class);

    @Autowired
    private HuanzheService huanzheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = huanzheService.queryPage(params);

        //字典表数据转换
        List<HuanzheView> list =(List<HuanzheView>)page.getList();
        for(HuanzheView c:list){
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
        HuanzheEntity huanzhe = huanzheService.selectById(id);
        if(huanzhe !=null){
            //entity转view
            HuanzheView view = new HuanzheView();
            BeanUtils.copyProperties( huanzhe , view );//把实体数据重构到view中

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
    public R save(@RequestBody HuanzheEntity huanzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huanzhe:{}",this.getClass().getName(),huanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<HuanzheEntity> queryWrapper = new EntityWrapper<HuanzheEntity>()
            .eq("username", huanzhe.getUsername())
            .or()
            .eq("huanzhe_phone", huanzhe.getHuanzhePhone())
            .or()
            .eq("huanzhe_id_number", huanzhe.getHuanzheIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuanzheEntity huanzheEntity = huanzheService.selectOne(queryWrapper);
        if(huanzheEntity==null){
            huanzhe.setCreateTime(new Date());
            huanzhe.setPassword("123456");
            huanzheService.insert(huanzhe);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuanzheEntity huanzhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huanzhe:{}",this.getClass().getName(),huanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<HuanzheEntity> queryWrapper = new EntityWrapper<HuanzheEntity>()
            .notIn("id",huanzhe.getId())
            .andNew()
            .eq("username", huanzhe.getUsername())
            .or()
            .eq("huanzhe_phone", huanzhe.getHuanzhePhone())
            .or()
            .eq("huanzhe_id_number", huanzhe.getHuanzheIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuanzheEntity huanzheEntity = huanzheService.selectOne(queryWrapper);
        if("".equals(huanzhe.getHuanzhePhoto()) || "null".equals(huanzhe.getHuanzhePhoto())){
                huanzhe.setHuanzhePhoto(null);
        }
        if(huanzheEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      huanzhe.set
            //  }
            huanzheService.updateById(huanzhe);//根据id更新
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
        huanzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        HuanzheEntity huanzhe = huanzheService.selectOne(new EntityWrapper<HuanzheEntity>().eq("username", username));
        if(huanzhe==null || !huanzhe.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(huanzhe.getId(),username, "huanzhe", "患者");
        R r = R.ok();
        r.put("token", token);
        r.put("role","患者");
        r.put("username",huanzhe.getHuanzheName());
        r.put("tableName","huanzhe");
        r.put("userId",huanzhe.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HuanzheEntity huanzhe){
    //    	ValidatorUtils.validateEntity(user);
        if(huanzheService.selectOne(new EntityWrapper<HuanzheEntity>().eq("username", huanzhe.getUsername()).orNew().eq("huanzhe_phone",huanzhe.getHuanzhePhone()).orNew().eq("huanzhe_id_number",huanzhe.getHuanzheIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        huanzhe.setCreateTime(new Date());
        huanzheService.insert(huanzhe);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HuanzheEntity huanzhe = new HuanzheEntity();
        huanzhe.setPassword("123456");
        huanzhe.setId(id);
        huanzheService.updateById(huanzhe);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrHuanzhe(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HuanzheEntity huanzhe = huanzheService.selectById(id);
        if(huanzhe !=null){
            //entity转view
            HuanzheView view = new HuanzheView();
            BeanUtils.copyProperties( huanzhe , view );//把实体数据重构到view中

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

