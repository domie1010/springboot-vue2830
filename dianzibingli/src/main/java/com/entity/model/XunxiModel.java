package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 医院讯息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XunxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 讯息名称
     */
    private String xunxiName;


    /**
     * 讯息类型
     */
    private Integer xunxiTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 讯息详情
     */
    private String xunxiContent;


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
	 * 获取：讯息名称
	 */
    public String getXunxiName() {
        return xunxiName;
    }


    /**
	 * 设置：讯息名称
	 */
    public void setXunxiName(String xunxiName) {
        this.xunxiName = xunxiName;
    }
    /**
	 * 获取：讯息类型
	 */
    public Integer getXunxiTypes() {
        return xunxiTypes;
    }


    /**
	 * 设置：讯息类型
	 */
    public void setXunxiTypes(Integer xunxiTypes) {
        this.xunxiTypes = xunxiTypes;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：讯息详情
	 */
    public String getXunxiContent() {
        return xunxiContent;
    }


    /**
	 * 设置：讯息详情
	 */
    public void setXunxiContent(String xunxiContent) {
        this.xunxiContent = xunxiContent;
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
