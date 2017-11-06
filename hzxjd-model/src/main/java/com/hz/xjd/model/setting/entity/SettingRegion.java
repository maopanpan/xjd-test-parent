package com.hz.xjd.model.setting.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "setting_region")
public class SettingRegion implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 区域code(唯一)
     */
    private Integer code;

    /**
     * 区域中文名
     */
    private String name;

    /**
     * 父区域code
     */
    private Integer pcode;

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
     * 获取区域code(唯一)
     *
     * @return code - 区域code(唯一)
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置区域code(唯一)
     *
     * @param code 区域code(唯一)
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取区域中文名
     *
     * @return name - 区域中文名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置区域中文名
     *
     * @param name 区域中文名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取父区域code
     *
     * @return pcode - 父区域code
     */
    public Integer getPcode() {
        return pcode;
    }

    /**
     * 设置父区域code
     *
     * @param pcode 父区域code
     */
    public void setPcode(Integer pcode) {
        this.pcode = pcode;
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
        SettingRegion other = (SettingRegion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPcode() == null ? other.getPcode() == null : this.getPcode().equals(other.getPcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPcode() == null) ? 0 : getPcode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", pcode=").append(pcode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}