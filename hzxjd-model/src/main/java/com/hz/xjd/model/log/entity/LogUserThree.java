package com.hz.xjd.model.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "log_user_three")
public class LogUserThree implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统用户
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 三方接口类型
     */
    @Column(name = "three_type")
    private String threeType;

    /**
     * 调用时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 调用描述
     */
    private String descr;

    /**
     * 调用状态
     */
    private String status;

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
     * 获取系统用户
     *
     * @return user_no - 系统用户
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置系统用户
     *
     * @param userNo 系统用户
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取三方接口类型
     *
     * @return three_type - 三方接口类型
     */
    public String getThreeType() {
        return threeType;
    }

    /**
     * 设置三方接口类型
     *
     * @param threeType 三方接口类型
     */
    public void setThreeType(String threeType) {
        this.threeType = threeType == null ? null : threeType.trim();
    }

    /**
     * 获取调用时间
     *
     * @return operate_time - 调用时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置调用时间
     *
     * @param operateTime 调用时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取调用描述
     *
     * @return descr - 调用描述
     */
    public String getDescr() {
        return descr;
    }

    /**
     * 设置调用描述
     *
     * @param descr 调用描述
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * 获取调用状态
     *
     * @return status - 调用状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置调用状态
     *
     * @param status 调用状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        LogUserThree other = (LogUserThree) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getThreeType() == null ? other.getThreeType() == null : this.getThreeType().equals(other.getThreeType()))
            && (this.getOperateTime() == null ? other.getOperateTime() == null : this.getOperateTime().equals(other.getOperateTime()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getThreeType() == null) ? 0 : getThreeType().hashCode());
        result = prime * result + ((getOperateTime() == null) ? 0 : getOperateTime().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userNo=").append(userNo);
        sb.append(", threeType=").append(threeType);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", descr=").append(descr);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}