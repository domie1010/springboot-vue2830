package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 医院讯息
 *
 * @author 
 * @email
 */
@TableName("xunxi")
public class XunxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XunxiEntity() {

	}

	public XunxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Xunxi{" +
            "id=" + id +
            ", xunxiName=" + xunxiName +
            ", xunxiTypes=" + xunxiTypes +
            ", insertTime=" + insertTime +
            ", xunxiContent=" + xunxiContent +
            ", createTime=" + createTime +
        "}";
    }
}
