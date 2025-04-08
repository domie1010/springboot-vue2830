package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 手术记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShoushuModel implements Serializable {
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
     * 手术名字
     */
    private String shoushuName;


    /**
     * 手术类型
     */
    private Integer shoushuTypes;


    /**
     * 手术时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shoushuTime;


    /**
     * 手术详情
     */
    private String shoushuContent;


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
	 * 获取：手术名字
	 */
    public String getShoushuName() {
        return shoushuName;
    }


    /**
	 * 设置：手术名字
	 */
    public void setShoushuName(String shoushuName) {
        this.shoushuName = shoushuName;
    }
    /**
	 * 获取：手术类型
	 */
    public Integer getShoushuTypes() {
        return shoushuTypes;
    }


    /**
	 * 设置：手术类型
	 */
    public void setShoushuTypes(Integer shoushuTypes) {
        this.shoushuTypes = shoushuTypes;
    }
    /**
	 * 获取：手术时间
	 */
    public Date getShoushuTime() {
        return shoushuTime;
    }


    /**
	 * 设置：手术时间
	 */
    public void setShoushuTime(Date shoushuTime) {
        this.shoushuTime = shoushuTime;
    }
    /**
	 * 获取：手术详情
	 */
    public String getShoushuContent() {
        return shoushuContent;
    }


    /**
	 * 设置：手术详情
	 */
    public void setShoushuContent(String shoushuContent) {
        this.shoushuContent = shoushuContent;
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
