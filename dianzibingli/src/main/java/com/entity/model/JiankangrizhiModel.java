package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 健康日记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangrizhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer huanzheId;


    /**
     * 日期
     */
    private String jiankangrizhiTime;


    /**
     * 饮食状况
     */
    private String yinshi;


    /**
     * 健康状况
     */
    private Integer jiankangTypes;


    /**
     * 血糖
     */
    private Integer xuetang;


    /**
     * 血压
     */
    private Integer xueya;


    /**
     * 血脂
     */
    private Integer xuezhi;


    /**
     * 评价人
     */
    private Integer yishengId;


    /**
     * 评价建议
     */
    private String jiankangrizhiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 设置：患者
	 */
    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 获取：日期
	 */
    public String getJiankangrizhiTime() {
        return jiankangrizhiTime;
    }


    /**
	 * 设置：日期
	 */
    public void setJiankangrizhiTime(String jiankangrizhiTime) {
        this.jiankangrizhiTime = jiankangrizhiTime;
    }
    /**
	 * 获取：饮食状况
	 */
    public String getYinshi() {
        return yinshi;
    }


    /**
	 * 设置：饮食状况
	 */
    public void setYinshi(String yinshi) {
        this.yinshi = yinshi;
    }
    /**
	 * 获取：健康状况
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }


    /**
	 * 设置：健康状况
	 */
    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 获取：血糖
	 */
    public Integer getXuetang() {
        return xuetang;
    }


    /**
	 * 设置：血糖
	 */
    public void setXuetang(Integer xuetang) {
        this.xuetang = xuetang;
    }
    /**
	 * 获取：血压
	 */
    public Integer getXueya() {
        return xueya;
    }


    /**
	 * 设置：血压
	 */
    public void setXueya(Integer xueya) {
        this.xueya = xueya;
    }
    /**
	 * 获取：血脂
	 */
    public Integer getXuezhi() {
        return xuezhi;
    }


    /**
	 * 设置：血脂
	 */
    public void setXuezhi(Integer xuezhi) {
        this.xuezhi = xuezhi;
    }
    /**
	 * 获取：评价人
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：评价人
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：评价建议
	 */
    public String getJiankangrizhiContent() {
        return jiankangrizhiContent;
    }


    /**
	 * 设置：评价建议
	 */
    public void setJiankangrizhiContent(String jiankangrizhiContent) {
        this.jiankangrizhiContent = jiankangrizhiContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
