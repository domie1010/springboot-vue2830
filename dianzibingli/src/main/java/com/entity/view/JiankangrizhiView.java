package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.JiankangrizhiEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 健康日记
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiankangrizhi")
public class JiankangrizhiView extends JiankangrizhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 健康状况的值
		*/
		private String jiankangValue;



		//级联表 huanzhe
			/**
			* 患者姓名
			*/
			private String huanzheName;
			/**
			* 患者手机号
			*/
			private String huanzhePhone;
			/**
			* 患者身份证号
			*/
			private String huanzheIdNumber;
			/**
			* 现住地址
			*/
			private String huanzheAddress;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 出生年月
			*/
			private Date huanzheTime;
			/**
			* 患者照片
			*/
			private String huanzhePhoto;

		//级联表 yisheng
			/**
			* 医生姓名
			*/
			private String yishengName;
			/**
			* 医生手机号
			*/
			private String yishengPhone;
			/**
			* 医生身份证号
			*/
			private String yishengIdNumber;
			/**
			* 医生照片
			*/
			private String yishengPhoto;

	public JiankangrizhiView() {

	}

	public JiankangrizhiView(JiankangrizhiEntity jiankangrizhiEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangrizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 健康状况的值
			*/
			public String getJiankangValue() {
				return jiankangValue;
			}
			/**
			* 设置： 健康状况的值
			*/
			public void setJiankangValue(String jiankangValue) {
				this.jiankangValue = jiankangValue;
			}










				//级联表的get和set huanzhe
					/**
					* 获取： 患者姓名
					*/
					public String getHuanzheName() {
						return huanzheName;
					}
					/**
					* 设置： 患者姓名
					*/
					public void setHuanzheName(String huanzheName) {
						this.huanzheName = huanzheName;
					}
					/**
					* 获取： 患者手机号
					*/
					public String getHuanzhePhone() {
						return huanzhePhone;
					}
					/**
					* 设置： 患者手机号
					*/
					public void setHuanzhePhone(String huanzhePhone) {
						this.huanzhePhone = huanzhePhone;
					}
					/**
					* 获取： 患者身份证号
					*/
					public String getHuanzheIdNumber() {
						return huanzheIdNumber;
					}
					/**
					* 设置： 患者身份证号
					*/
					public void setHuanzheIdNumber(String huanzheIdNumber) {
						this.huanzheIdNumber = huanzheIdNumber;
					}
					/**
					* 获取： 现住地址
					*/
					public String getHuanzheAddress() {
						return huanzheAddress;
					}
					/**
					* 设置： 现住地址
					*/
					public void setHuanzheAddress(String huanzheAddress) {
						this.huanzheAddress = huanzheAddress;
					}
					/**
					* 获取： 出生年月
					*/
					public Date getHuanzheTime() {
						return huanzheTime;
					}
					/**
					* 设置： 出生年月
					*/
					public void setHuanzheTime(Date huanzheTime) {
						this.huanzheTime = huanzheTime;
					}
					/**
					* 获取： 患者照片
					*/
					public String getHuanzhePhoto() {
						return huanzhePhoto;
					}
					/**
					* 设置： 患者照片
					*/
					public void setHuanzhePhoto(String huanzhePhoto) {
						this.huanzhePhoto = huanzhePhoto;
					}






















				//级联表的get和set yisheng
					/**
					* 获取： 医生姓名
					*/
					public String getYishengName() {
						return yishengName;
					}
					/**
					* 设置： 医生姓名
					*/
					public void setYishengName(String yishengName) {
						this.yishengName = yishengName;
					}
					/**
					* 获取： 医生手机号
					*/
					public String getYishengPhone() {
						return yishengPhone;
					}
					/**
					* 设置： 医生手机号
					*/
					public void setYishengPhone(String yishengPhone) {
						this.yishengPhone = yishengPhone;
					}
					/**
					* 获取： 医生身份证号
					*/
					public String getYishengIdNumber() {
						return yishengIdNumber;
					}
					/**
					* 设置： 医生身份证号
					*/
					public void setYishengIdNumber(String yishengIdNumber) {
						this.yishengIdNumber = yishengIdNumber;
					}
					/**
					* 获取： 医生照片
					*/
					public String getYishengPhoto() {
						return yishengPhoto;
					}
					/**
					* 设置： 医生照片
					*/
					public void setYishengPhoto(String yishengPhoto) {
						this.yishengPhoto = yishengPhoto;
					}






}
