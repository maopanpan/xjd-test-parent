package com.hz.xjd.model.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "log_sys_operate")
public class LogSysOperate implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统用户编号
     */
    @Column(name = "sys_user_id")
    private Integer sysUserId;

    /**
     * 操作类型
     */
    private String type;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 操作描述
     */
    private String descr;

    /**
     * IP
     */
    private String ip;

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
     * 获取系统用户编号
     *
     * @return sys_user_id - 系统用户编号
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置系统用户编号
     *
     * @param sysUserId 系统用户编号
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取操作类型
     *
     * @return type - 操作类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置操作类型
     *
     * @param type 操作类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取操作时间
     *
     * @return operate_time - 操作时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置操作时间
     *
     * @param operateTime 操作时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取操作描述
     *
     * @return descr - 操作描述
     */
    public String getDescr() {
        return descr;
    }

    /**
     * 设置操作描述
     *
     * @param descr 操作描述
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * 获取IP
     *
     * @return ip - IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置IP
     *
     * @param ip IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
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
        LogSysOperate other = (LogSysOperate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getOperateTime() == null ? other.getOperateTime() == null : this.getOperateTime().equals(other.getOperateTime()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getOperateTime() == null) ? 0 : getOperateTime().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", type=").append(type);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", descr=").append(descr);
        sb.append(", ip=").append(ip);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}