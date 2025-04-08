package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.MeirituijianEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 每日推荐
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("meirituijian")
public class MeirituijianView extends MeirituijianEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public MeirituijianView() {

	}

	public MeirituijianView(MeirituijianEntity meirituijianEntity) {
		try {
			BeanUtils.copyProperties(this, meirituijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















}
