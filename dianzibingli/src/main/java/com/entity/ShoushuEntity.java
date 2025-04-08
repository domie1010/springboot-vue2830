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
 * 手术记录
 *
 * @author 
 * @email
 */
@TableName("shoushu")
public class ShoushuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShoushuEntity() {

	}

	public ShoushuEntity(T t) {
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
     * 患者
     */
    @TableField(value = "huanzhe_id")

    private Integer huanzheId;


    /**
     * 手术名字
     */
    @TableField(value = "shoushu_name")

    private String shoushuName;


    /**
     * 手术类型
     */
    @TableField(value = "shoushu_types")

    private Integer shoushuTypes;


    /**
     * 手术时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shoushu_time",fill = FieldFill.UPDATE)

    private Date shoushuTime;


    /**
     * 手术详情
     */
    @TableField(value = "shoushu_content")

    private String shoushuContent;


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
	 * 设置：手术名字
	 */
    public String getShoushuName() {
        return shoushuName;
    }


    /**
	 * 获取：手术名字
	 */

    public void setShoushuName(String shoushuName) {
        this.shoushuName = shoushuName;
    }
    /**
	 * 设置：手术类型
	 */
    public Integer getShoushuTypes() {
        return shoushuTypes;
    }


    /**
	 * 获取：手术类型
	 */

    public void setShoushuTypes(Integer shoushuTypes) {
        this.shoushuTypes = shoushuTypes;
    }
    /**
	 * 设置：手术时间
	 */
    public Date getShoushuTime() {
        return shoushuTime;
    }


    /**
	 * 获取：手术时间
	 */

    public void setShoushuTime(Date shoushuTime) {
        this.shoushuTime = shoushuTime;
    }
    /**
	 * 设置：手术详情
	 */
    public String getShoushuContent() {
        return shoushuContent;
    }


    /**
	 * 获取：手术详情
	 */

    public void setShoushuContent(String shoushuContent) {
        this.shoushuContent = shoushuContent;
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
        return "Shoushu{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", shoushuName=" + shoushuName +
            ", shoushuTypes=" + shoushuTypes +
            ", shoushuTime=" + shoushuTime +
            ", shoushuContent=" + shoushuContent +
            ", createTime=" + createTime +
        "}";
    }
}
