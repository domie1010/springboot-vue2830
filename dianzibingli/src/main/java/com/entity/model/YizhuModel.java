package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 医嘱
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YizhuModel implements Serializable {
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
     * 医嘱名字
     */
    private String yizhuName;


    /**
     * 医嘱类型
     */
    private Integer yizhuTypes;


    /**
     * 医嘱时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yizhuTime;


    /**
     * 医嘱详情
     */
    private String yizhuContent;


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
	 * 获取：医嘱名字
	 */
    public String getYizhuName() {
        return yizhuName;
    }


    /**
	 * 设置：医嘱名字
	 */
    public void setYizhuName(String yizhuName) {
        this.yizhuName = yizhuName;
    }
    /**
	 * 获取：医嘱类型
	 */
    public Integer getYizhuTypes() {
        return yizhuTypes;
    }


    /**
	 * 设置：医嘱类型
	 */
    public void setYizhuTypes(Integer yizhuTypes) {
        this.yizhuTypes = yizhuTypes;
    }
    /**
	 * 获取：医嘱时间
	 */
    public Date getYizhuTime() {
        return yizhuTime;
    }


    /**
	 * 设置：医嘱时间
	 */
    public void setYizhuTime(Date yizhuTime) {
        this.yizhuTime = yizhuTime;
    }
    /**
	 * 获取：医嘱详情
	 */
    public String getYizhuContent() {
        return yizhuContent;
    }


    /**
	 * 设置：医嘱详情
	 */
    public void setYizhuContent(String yizhuContent) {
        this.yizhuContent = yizhuContent;
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
