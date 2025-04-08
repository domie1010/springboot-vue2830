package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.BingliEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 病例
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bingli")
public class BingliView extends BingliEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 病例类型的值
		*/
		private String bingliValue;
		/**
		* 入院类型的值
		*/
		private String ruyuanValue;
		/**
		* 状态的值
		*/
		private String bingliYesonValue;



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

	public BingliView() {

	}

	public BingliView(BingliEntity bingliEntity) {
		try {
			BeanUtils.copyProperties(this, bingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 病例类型的值
			*/
			public String getBingliValue() {
				return bingliValue;
			}
			/**
			* 设置： 病例类型的值
			*/
			public void setBingliValue(String bingliValue) {
				this.bingliValue = bingliValue;
			}
			/**
			* 获取： 入院类型的值
			*/
			public String getRuyuanValue() {
				return ruyuanValue;
			}
			/**
			* 设置： 入院类型的值
			*/
			public void setRuyuanValue(String ruyuanValue) {
				this.ruyuanValue = ruyuanValue;
			}
			/**
			* 获取： 状态的值
			*/
			public String getBingliYesonValue() {
				return bingliYesonValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setBingliYesonValue(String bingliYesonValue) {
				this.bingliYesonValue = bingliYesonValue;
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


















}
