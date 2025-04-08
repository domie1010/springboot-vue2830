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
 * 护理记录
 *
 * @author 
 * @email
 */
@TableName("huli")
public class HuliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuliEntity() {

	}

	public HuliEntity(T t) {
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
     * 护理名字
     */
    @TableField(value = "huli_name")

    private String huliName;


    /**
     * 护理类型
     */
    @TableField(value = "huli_types")

    private Integer huliTypes;


    /**
     * 护理时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "huli_time",fill = FieldFill.UPDATE)

    private Date huliTime;


    /**
     * 护理详情
     */
    @TableField(value = "huli_content")

    private String huliContent;


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
	 * 设置：护理名字
	 */
    public String getHuliName() {
        return huliName;
    }


    /**
	 * 获取：护理名字
	 */

    public void setHuliName(String huliName) {
        this.huliName = huliName;
    }
    /**
	 * 设置：护理类型
	 */
    public Integer getHuliTypes() {
        return huliTypes;
    }


    /**
	 * 获取：护理类型
	 */

    public void setHuliTypes(Integer huliTypes) {
        this.huliTypes = huliTypes;
    }
    /**
	 * 设置：护理时间
	 */
    public Date getHuliTime() {
        return huliTime;
    }


    /**
	 * 获取：护理时间
	 */

    public void setHuliTime(Date huliTime) {
        this.huliTime = huliTime;
    }
    /**
	 * 设置：护理详情
	 */
    public String getHuliContent() {
        return huliContent;
    }


    /**
	 * 获取：护理详情
	 */

    public void setHuliContent(String huliContent) {
        this.huliContent = huliContent;
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
        return "Huli{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", huliName=" + huliName +
            ", huliTypes=" + huliTypes +
            ", huliTime=" + huliTime +
            ", huliContent=" + huliContent +
            ", createTime=" + createTime +
        "}";
    }
}
