package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 医院讯息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xunxi")
public class XunxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 讯息名称
     */

    @TableField(value = "xunxi_name")
    private String xunxiName;


    /**
     * 讯息类型
     */

    @TableField(value = "xunxi_types")
    private Integer xunxiTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 讯息详情
     */

    @TableField(value = "xunxi_content")
    private String xunxiContent;


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
	 * 设置：讯息名称
	 */
    public String getXunxiName() {
        return xunxiName;
    }


    /**
	 * 获取：讯息名称
	 */

    public void setXunxiName(String xunxiName) {
        this.xunxiName = xunxiName;
    }
    /**
	 * 设置：讯息类型
	 */
    public Integer getXunxiTypes() {
        return xunxiTypes;
    }


    /**
	 * 获取：讯息类型
	 */

    public void setXunxiTypes(Integer xunxiTypes) {
        this.xunxiTypes = xunxiTypes;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：讯息详情
	 */
    public String getXunxiContent() {
        return xunxiContent;
    }


    /**
	 * 获取：讯息详情
	 */

    public void setXunxiContent(String xunxiContent) {
        this.xunxiContent = xunxiContent;
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
