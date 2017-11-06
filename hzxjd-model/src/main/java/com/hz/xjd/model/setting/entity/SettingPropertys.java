package com.hz.xjd.model.setting.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "setting_propertys")
public class SettingPropertys implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性类别(third_interface:三方接口配置,basic_settings:系统基本配置,constant_settings:系统常量配置,variable_settings:系统变量配置,third_account:三方账户配置)
     */
    private String type;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 显示顺序
     */
    @Column(name = "display_sort")
    private Integer displaySort;

    /**
     * 描述
     */
    private String descr;

    /**
     * 删除标示(0:未删除 1:删除)
     */
    @Column(name = "delete_flg")
    private Integer deleteFlg;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 修改人
     */
    private Integer modifier;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取属性类别(third_interface:三方接口配置,basic_settings:系统基本配置,constant_settings:系统常量配置,variable_settings:系统变量配置,third_account:三方账户配置)
     *
     * @return type - 属性类别(third_interface:三方接口配置,basic_settings:系统基本配置,constant_settings:系统常量配置,variable_settings:系统变量配置,third_account:三方账户配置)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置属性类别(third_interface:三方接口配置,basic_settings:系统基本配置,constant_settings:系统常量配置,variable_settings:系统变量配置,third_account:三方账户配置)
     *
     * @param type 属性类别(third_interface:三方接口配置,basic_settings:系统基本配置,constant_settings:系统常量配置,variable_settings:系统变量配置,third_account:三方账户配置)
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取键
     *
     * @return key - 键
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置键
     *
     * @param key 键
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return display_sort - 显示顺序
     */
    public Integer getDisplaySort() {
        return displaySort;
    }

    /**
     * 设置显示顺序
     *
     * @param displaySort 显示顺序
     */
    public void setDisplaySort(Integer displaySort) {
        this.displaySort = displaySort;
    }

    /**
     * 获取描述
     *
     * @return descr - 描述
     */
    public String getDescr() {
        return descr;
    }

    /**
     * 设置描述
     *
     * @param descr 描述
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * 获取删除标示(0:未删除 1:删除)
     *
     * @return delete_flg - 删除标示(0:未删除 1:删除)
     */
    public Integer getDeleteFlg() {
        return deleteFlg;
    }

    /**
     * 设置删除标示(0:未删除 1:删除)
     *
     * @param deleteFlg 删除标示(0:未删除 1:删除)
     */
    public void setDeleteFlg(Integer deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public Integer getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SettingPropertys other = (SettingPropertys) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getKey() == null ? other.getKey() == null : this.getKey().equals(other.getKey()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getDisplaySort() == null ? other.getDisplaySort() == null : this.getDisplaySort().equals(other.getDisplaySort()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getDeleteFlg() == null ? other.getDeleteFlg() == null : this.getDeleteFlg().equals(other.getDeleteFlg()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getDisplaySort() == null) ? 0 : getDisplaySort().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getDeleteFlg() == null) ? 0 : getDeleteFlg().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", key=").append(key);
        sb.append(", value=").append(value);
        sb.append(", displaySort=").append(displaySort);
        sb.append(", descr=").append(descr);
        sb.append(", deleteFlg=").append(deleteFlg);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}