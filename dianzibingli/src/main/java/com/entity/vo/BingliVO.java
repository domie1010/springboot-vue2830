package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 病例
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingli")
public class BingliVO implements Serializable {
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
     * 病例类型
     */

    @TableField(value = "bingli_types")
    private Integer bingliTypes;


    /**
     * 入院类型
     */

    @TableField(value = "ruyuan_types")
    private Integer ruyuanTypes;


    /**
     * 入院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruyuan_time")
    private Date ruyuanTime;


    /**
     * 病例文件
     */

    @TableField(value = "bingli_file")
    private String bingliFile;


    /**
     * 诊断
     */

    @TableField(value = "bingli_content")
    private String bingliContent;


    /**
     * 状态
     */

    @TableField(value = "bingli_yeson_types")
    private Integer bingliYesonTypes;


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
	 * 设置：病例类型
	 */
    public Integer getBingliTypes() {
        return bingliTypes;
    }


    /**
	 * 获取：病例类型
	 */

    public void setBingliTypes(Integer bingliTypes) {
        this.bingliTypes = bingliTypes;
    }
    /**
	 * 设置：入院类型
	 */
    public Integer getRuyuanTypes() {
        return ruyuanTypes;
    }


    /**
	 * 获取：入院类型
	 */

    public void setRuyuanTypes(Integer ruyuanTypes) {
        this.ruyuanTypes = ruyuanTypes;
    }
    /**
	 * 设置：入院时间
	 */
    public Date getRuyuanTime() {
        return ruyuanTime;
    }


    /**
	 * 获取：入院时间
	 */

    public void setRuyuanTime(Date ruyuanTime) {
        this.ruyuanTime = ruyuanTime;
    }
    /**
	 * 设置：病例文件
	 */
    public String getBingliFile() {
        return bingliFile;
    }


    /**
	 * 获取：病例文件
	 */

    public void setBingliFile(String bingliFile) {
        this.bingliFile = bingliFile;
    }
    /**
	 * 设置：诊断
	 */
    public String getBingliContent() {
        return bingliContent;
    }


    /**
	 * 获取：诊断
	 */

    public void setBingliContent(String bingliContent) {
        this.bingliContent = bingliContent;
    }
    /**
	 * 设置：状态
	 */
    public Integer getBingliYesonTypes() {
        return bingliYesonTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setBingliYesonTypes(Integer bingliYesonTypes) {
        this.bingliYesonTypes = bingliYesonTypes;
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
