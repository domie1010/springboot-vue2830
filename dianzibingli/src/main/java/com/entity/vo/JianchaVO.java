package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 检查记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiancha")
public class JianchaVO implements Serializable {
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
     * 检查名字
     */

    @TableField(value = "jiancha_name")
    private String jianchaName;


    /**
     * 检查类型
     */

    @TableField(value = "jiancha_types")
    private Integer jianchaTypes;


    /**
     * 检查时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiancha_time")
    private Date jianchaTime;


    /**
     * 检查详情
     */

    @TableField(value = "jiancha_content")
    private String jianchaContent;


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
	 * 设置：检查名字
	 */
    public String getJianchaName() {
        return jianchaName;
    }


    /**
	 * 获取：检查名字
	 */

    public void setJianchaName(String jianchaName) {
        this.jianchaName = jianchaName;
    }
    /**
	 * 设置：检查类型
	 */
    public Integer getJianchaTypes() {
        return jianchaTypes;
    }


    /**
	 * 获取：检查类型
	 */

    public void setJianchaTypes(Integer jianchaTypes) {
        this.jianchaTypes = jianchaTypes;
    }
    /**
	 * 设置：检查时间
	 */
    public Date getJianchaTime() {
        return jianchaTime;
    }


    /**
	 * 获取：检查时间
	 */

    public void setJianchaTime(Date jianchaTime) {
        this.jianchaTime = jianchaTime;
    }
    /**
	 * 设置：检查详情
	 */
    public String getJianchaContent() {
        return jianchaContent;
    }


    /**
	 * 获取：检查详情
	 */

    public void setJianchaContent(String jianchaContent) {
        this.jianchaContent = jianchaContent;
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
