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
 * 医嘱
 *
 * @author 
 * @email
 */
@TableName("yizhu")
public class YizhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YizhuEntity() {

	}

	public YizhuEntity(T t) {
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
     * 医嘱名字
     */
    @TableField(value = "yizhu_name")

    private String yizhuName;


    /**
     * 医嘱类型
     */
    @TableField(value = "yizhu_types")

    private Integer yizhuTypes;


    /**
     * 医嘱时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "yizhu_time",fill = FieldFill.UPDATE)

    private Date yizhuTime;


    /**
     * 医嘱详情
     */
    @TableField(value = "yizhu_content")

    private String yizhuContent;


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
	 * 设置：医嘱名字
	 */
    public String getYizhuName() {
        return yizhuName;
    }


    /**
	 * 获取：医嘱名字
	 */

    public void setYizhuName(String yizhuName) {
        this.yizhuName = yizhuName;
    }
    /**
	 * 设置：医嘱类型
	 */
    public Integer getYizhuTypes() {
        return yizhuTypes;
    }


    /**
	 * 获取：医嘱类型
	 */

    public void setYizhuTypes(Integer yizhuTypes) {
        this.yizhuTypes = yizhuTypes;
    }
    /**
	 * 设置：医嘱时间
	 */
    public Date getYizhuTime() {
        return yizhuTime;
    }


    /**
	 * 获取：医嘱时间
	 */

    public void setYizhuTime(Date yizhuTime) {
        this.yizhuTime = yizhuTime;
    }
    /**
	 * 设置：医嘱详情
	 */
    public String getYizhuContent() {
        return yizhuContent;
    }


    /**
	 * 获取：医嘱详情
	 */

    public void setYizhuContent(String yizhuContent) {
        this.yizhuContent = yizhuContent;
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
        return "Yizhu{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", yizhuName=" + yizhuName +
            ", yizhuTypes=" + yizhuTypes +
            ", yizhuTime=" + yizhuTime +
            ", yizhuContent=" + yizhuContent +
            ", createTime=" + createTime +
        "}";
    }
}
