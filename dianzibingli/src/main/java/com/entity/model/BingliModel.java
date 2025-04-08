package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 病例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingliModel implements Serializable {
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
     * 病例类型
     */
    private Integer bingliTypes;


    /**
     * 入院类型
     */
    private Integer ruyuanTypes;


    /**
     * 入院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruyuanTime;


    /**
     * 病例文件
     */
    private String bingliFile;


    /**
     * 诊断
     */
    private String bingliContent;


    /**
     * 状态
     */
    private Integer bingliYesonTypes;


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
	 * 获取：病例类型
	 */
    public Integer getBingliTypes() {
        return bingliTypes;
    }


    /**
	 * 设置：病例类型
	 */
    public void setBingliTypes(Integer bingliTypes) {
        this.bingliTypes = bingliTypes;
    }
    /**
	 * 获取：入院类型
	 */
    public Integer getRuyuanTypes() {
        return ruyuanTypes;
    }


    /**
	 * 设置：入院类型
	 */
    public void setRuyuanTypes(Integer ruyuanTypes) {
        this.ruyuanTypes = ruyuanTypes;
    }
    /**
	 * 获取：入院时间
	 */
    public Date getRuyuanTime() {
        return ruyuanTime;
    }


    /**
	 * 设置：入院时间
	 */
    public void setRuyuanTime(Date ruyuanTime) {
        this.ruyuanTime = ruyuanTime;
    }
    /**
	 * 获取：病例文件
	 */
    public String getBingliFile() {
        return bingliFile;
    }


    /**
	 * 设置：病例文件
	 */
    public void setBingliFile(String bingliFile) {
        this.bingliFile = bingliFile;
    }
    /**
	 * 获取：诊断
	 */
    public String getBingliContent() {
        return bingliContent;
    }


    /**
	 * 设置：诊断
	 */
    public void setBingliContent(String bingliContent) {
        this.bingliContent = bingliContent;
    }
    /**
	 * 获取：状态
	 */
    public Integer getBingliYesonTypes() {
        return bingliYesonTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setBingliYesonTypes(Integer bingliYesonTypes) {
        this.bingliYesonTypes = bingliYesonTypes;
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
