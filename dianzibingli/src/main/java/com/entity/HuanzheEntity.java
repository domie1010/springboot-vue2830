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
 * 患者
 *
 * @author 
 * @email
 */
@TableName("huanzhe")
public class HuanzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuanzheEntity() {

	}

	public HuanzheEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 患者姓名
     */
    @TableField(value = "huanzhe_name")

    private String huanzheName;


    /**
     * 患者手机号
     */
    @TableField(value = "huanzhe_phone")

    private String huanzhePhone;


    /**
     * 患者身份证号
     */
    @TableField(value = "huanzhe_id_number")

    private String huanzheIdNumber;


    /**
     * 现住地址
     */
    @TableField(value = "huanzhe_address")

    private String huanzheAddress;


    /**
     * 出生年月
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "huanzhe_time",fill = FieldFill.UPDATE)

    private Date huanzheTime;


    /**
     * 患者照片
     */
    @TableField(value = "huanzhe_photo")

    private String huanzhePhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：患者姓名
	 */
    public String getHuanzheName() {
        return huanzheName;
    }


    /**
	 * 获取：患者姓名
	 */

    public void setHuanzheName(String huanzheName) {
        this.huanzheName = huanzheName;
    }
    /**
	 * 设置：患者手机号
	 */
    public String getHuanzhePhone() {
        return huanzhePhone;
    }


    /**
	 * 获取：患者手机号
	 */

    public void setHuanzhePhone(String huanzhePhone) {
        this.huanzhePhone = huanzhePhone;
    }
    /**
	 * 设置：患者身份证号
	 */
    public String getHuanzheIdNumber() {
        return huanzheIdNumber;
    }


    /**
	 * 获取：患者身份证号
	 */

    public void setHuanzheIdNumber(String huanzheIdNumber) {
        this.huanzheIdNumber = huanzheIdNumber;
    }
    /**
	 * 设置：现住地址
	 */
    public String getHuanzheAddress() {
        return huanzheAddress;
    }


    /**
	 * 获取：现住地址
	 */

    public void setHuanzheAddress(String huanzheAddress) {
        this.huanzheAddress = huanzheAddress;
    }
    /**
	 * 设置：出生年月
	 */
    public Date getHuanzheTime() {
        return huanzheTime;
    }


    /**
	 * 获取：出生年月
	 */

    public void setHuanzheTime(Date huanzheTime) {
        this.huanzheTime = huanzheTime;
    }
    /**
	 * 设置：患者照片
	 */
    public String getHuanzhePhoto() {
        return huanzhePhoto;
    }


    /**
	 * 获取：患者照片
	 */

    public void setHuanzhePhoto(String huanzhePhoto) {
        this.huanzhePhoto = huanzhePhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
        return "Huanzhe{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", huanzheName=" + huanzheName +
            ", huanzhePhone=" + huanzhePhone +
            ", huanzheIdNumber=" + huanzheIdNumber +
            ", huanzheAddress=" + huanzheAddress +
            ", huanzheTime=" + huanzheTime +
            ", huanzhePhoto=" + huanzhePhoto +
            ", sexTypes=" + sexTypes +
            ", createTime=" + createTime +
        "}";
    }
}
