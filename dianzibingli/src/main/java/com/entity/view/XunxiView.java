package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.XunxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 医院讯息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xunxi")
public class XunxiView extends XunxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 讯息类型的值
		*/
		private String xunxiValue;



	public XunxiView() {

	}

	public XunxiView(XunxiEntity xunxiEntity) {
		try {
			BeanUtils.copyProperties(this, xunxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 讯息类型的值
			*/
			public String getXunxiValue() {
				return xunxiValue;
			}
			/**
			* 设置： 讯息类型的值
			*/
			public void setXunxiValue(String xunxiValue) {
				this.xunxiValue = xunxiValue;
			}














}
