package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 护理记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuliModel implements Serializable {
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
     * 护理名字
     */
    private String huliName;


    /**
     * 护理类型
     */
    private Integer huliTypes;


    /**
     * 护理时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huliTime;


    /**
     * 护理详情
     */
    private String huliContent;


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
	 * 获取：护理名字
	 */
    public String getHuliName() {
        return huliName;
    }


    /**
	 * 设置：护理名字
	 */
    public void setHuliName(String huliName) {
        this.huliName = huliName;
    }
    /**
	 * 获取：护理类型
	 */
    public Integer getHuliTypes() {
        return huliTypes;
    }


    /**
	 * 设置：护理类型
	 */
    public void setHuliTypes(Integer huliTypes) {
        this.huliTypes = huliTypes;
    }
    /**
	 * 获取：护理时间
	 */
    public Date getHuliTime() {
        return huliTime;
    }


    /**
	 * 设置：护理时间
	 */
    public void setHuliTime(Date huliTime) {
        this.huliTime = huliTime;
    }
    /**
	 * 获取：护理详情
	 */
    public String getHuliContent() {
        return huliContent;
    }


    /**
	 * 设置：护理详情
	 */
    public void setHuliContent(String huliContent) {
        this.huliContent = huliContent;
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
