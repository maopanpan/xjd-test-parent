package com.hz.xjd.model.setting.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "setting_constants")
public class SettingConstants implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 常量类型
     */
    private String type;

    /**
     * 名称
     */
    private String key;

    /**
     * 常量值
     */
    private String value;

    /**
     * 描述
     */
    private String descr;

    /**
     * 最后更新时间
     */
    private Date lastupdate;

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
     * 获取常量类型
     *
     * @return type - 常量类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置常量类型
     *
     * @param type 常量类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取名称
     *
     * @return key - 名称
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置名称
     *
     * @param key 名称
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取常量值
     *
     * @return value - 常量值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置常量值
     *
     * @param value 常量值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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
     * 获取最后更新时间
     *
     * @return lastupdate - 最后更新时间
     */
    public Date getLastupdate() {
        return lastupdate;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastupdate 最后更新时间
     */
    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
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
        SettingConstants other = (SettingConstants) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getKey() == null ? other.getKey() == null : this.getKey().equals(other.getKey()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getLastupdate() == null ? other.getLastupdate() == null : this.getLastupdate().equals(other.getLastupdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getLastupdate() == null) ? 0 : getLastupdate().hashCode());
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
        sb.append(", descr=").append(descr);
        sb.append(", lastupdate=").append(lastupdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}