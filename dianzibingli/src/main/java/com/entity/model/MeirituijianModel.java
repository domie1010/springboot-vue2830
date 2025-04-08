package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 每日推荐
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirituijianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 名称
     */
    private String meirituijianName;


    /**
     * 日期
     */
    private String meirituijianTime;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 详情
     */
    private String meirituijianContent;


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
	 * 获取：名称
	 */
    public String getMeirituijianName() {
        return meirituijianName;
    }


    /**
	 * 设置：名称
	 */
    public void setMeirituijianName(String meirituijianName) {
        this.meirituijianName = meirituijianName;
    }
    /**
	 * 获取：日期
	 */
    public String getMeirituijianTime() {
        return meirituijianTime;
    }


    /**
	 * 设置：日期
	 */
    public void setMeirituijianTime(String meirituijianTime) {
        this.meirituijianTime = meirituijianTime;
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
	 * 获取：详情
	 */
    public String getMeirituijianContent() {
        return meirituijianContent;
    }


    /**
	 * 设置：详情
	 */
    public void setMeirituijianContent(String meirituijianContent) {
        this.meirituijianContent = meirituijianContent;
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
