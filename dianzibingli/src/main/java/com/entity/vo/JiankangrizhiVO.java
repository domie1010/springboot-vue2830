package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 健康日记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangrizhi")
public class JiankangrizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 患者
     */

    @TableField(value = "huanzhe_id")
    private Integer huanzheId;


    /**
     * 日期
     */

    @TableField(value = "jiankangrizhi_time")
    private String jiankangrizhiTime;


    /**
     * 饮食状况
     */

    @TableField(value = "yinshi")
    private String yinshi;


    /**
     * 健康状况
     */

    @TableField(value = "jiankang_types")
    private Integer jiankangTypes;


    /**
     * 血糖
     */

    @TableField(value = "xuetang")
    private Integer xuetang;


    /**
     * 血压
     */

    @TableField(value = "xueya")
    private Integer xueya;


    /**
     * 血脂
     */

    @TableField(value = "xuezhi")
    private Integer xuezhi;


    /**
     * 评价人
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 评价建议
     */

    @TableField(value = "jiankangrizhi_content")
    private String jiankangrizhiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 获取：患者
	 */

    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 设置：日期
	 */
    public String getJiankangrizhiTime() {
        return jiankangrizhiTime;
    }


    /**
	 * 获取：日期
	 */

    public void setJiankangrizhiTime(String jiankangrizhiTime) {
        this.jiankangrizhiTime = jiankangrizhiTime;
    }
    /**
	 * 设置：饮食状况
	 */
    public String getYinshi() {
        return yinshi;
    }


    /**
	 * 获取：饮食状况
	 */

    public void setYinshi(String yinshi) {
        this.yinshi = yinshi;
    }
    /**
	 * 设置：健康状况
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }


    /**
	 * 获取：健康状况
	 */

    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 设置：血糖
	 */
    public Integer getXuetang() {
        return xuetang;
    }


    /**
	 * 获取：血糖
	 */

    public void setXuetang(Integer xuetang) {
        this.xuetang = xuetang;
    }
    /**
	 * 设置：血压
	 */
    public Integer getXueya() {
        return xueya;
    }


    /**
	 * 获取：血压
	 */

    public void setXueya(Integer xueya) {
        this.xueya = xueya;
    }
    /**
	 * 设置：血脂
	 */
    public Integer getXuezhi() {
        return xuezhi;
    }


    /**
	 * 获取：血脂
	 */

    public void setXuezhi(Integer xuezhi) {
        this.xuezhi = xuezhi;
    }
    /**
	 * 设置：评价人
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：评价人
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：评价建议
	 */
    public String getJiankangrizhiContent() {
        return jiankangrizhiContent;
    }


    /**
	 * 获取：评价建议
	 */

    public void setJiankangrizhiContent(String jiankangrizhiContent) {
        this.jiankangrizhiContent = jiankangrizhiContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
