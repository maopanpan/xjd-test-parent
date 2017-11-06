package com.hz.xjd.model.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "log_sys_setting")
public class LogSysSetting implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模块名称
     */
    @Column(name = "mod_name")
    private String modName;

    /**
     * 字段描述
     */
    private String descr;

    /**
     * 修改前
     */
    private String before;

    /**
     * 修改后
     */
    private String after;

    /**
     * 操作人id
     */
    @Column(name = "sys_user_id")
    private Integer sysUserId;

    /**
     * 最后更改时间
     */
    private Date lastupdate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取模块名称
     *
     * @return mod_name - 模块名称
     */
    public String getModName() {
        return modName;
    }

    /**
     * 设置模块名称
     *
     * @param modName 模块名称
     */
    public void setModName(String modName) {
        this.modName = modName == null ? null : modName.trim();
    }

    /**
     * 获取字段描述
     *
     * @return descr - 字段描述
     */
    public String getDescr() {
        return descr;
    }

    /**
     * 设置字段描述
     *
     * @param descr 字段描述
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * 获取修改前
     *
     * @return before - 修改前
     */
    public String getBefore() {
        return before;
    }

    /**
     * 设置修改前
     *
     * @param before 修改前
     */
    public void setBefore(String before) {
        this.before = before == null ? null : before.trim();
    }

    /**
     * 获取修改后
     *
     * @return after - 修改后
     */
    public String getAfter() {
        return after;
    }

    /**
     * 设置修改后
     *
     * @param after 修改后
     */
    public void setAfter(String after) {
        this.after = after == null ? null : after.trim();
    }

    /**
     * 获取操作人id
     *
     * @return sys_user_id - 操作人id
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置操作人id
     *
     * @param sysUserId 操作人id
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取最后更改时间
     *
     * @return lastupdate - 最后更改时间
     */
    public Date getLastupdate() {
        return lastupdate;
    }

    /**
     * 设置最后更改时间
     *
     * @param lastupdate 最后更改时间
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
        LogSysSetting other = (LogSysSetting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModName() == null ? other.getModName() == null : this.getModName().equals(other.getModName()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getBefore() == null ? other.getBefore() == null : this.getBefore().equals(other.getBefore()))
            && (this.getAfter() == null ? other.getAfter() == null : this.getAfter().equals(other.getAfter()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getLastupdate() == null ? other.getLastupdate() == null : this.getLastupdate().equals(other.getLastupdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModName() == null) ? 0 : getModName().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getBefore() == null) ? 0 : getBefore().hashCode());
        result = prime * result + ((getAfter() == null) ? 0 : getAfter().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
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
        sb.append(", modName=").append(modName);
        sb.append(", descr=").append(descr);
        sb.append(", before=").append(before);
        sb.append(", after=").append(after);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", lastupdate=").append(lastupdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}