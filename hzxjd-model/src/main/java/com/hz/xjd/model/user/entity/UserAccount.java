package com.hz.xjd.model.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_account")
public class UserAccount implements Serializable {
    /**
     * 用户编号(内部用)
     */
    @Id
    @Column(name = "user_no")
    private String userNo;

    /**
     * 账户总额(可用余额+锁定资金)
     */
    private BigDecimal total;

    /**
     * 可用余额
     */
    private BigDecimal available;

    /**
     * 锁定资金
     */
    private BigDecimal locked;

    /**
     * 最后更新时间
     */
    private Date lastupdate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户编号(内部用)
     *
     * @return user_no - 用户编号(内部用)
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户编号(内部用)
     *
     * @param userNo 用户编号(内部用)
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取账户总额(可用余额+锁定资金)
     *
     * @return total - 账户总额(可用余额+锁定资金)
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * 设置账户总额(可用余额+锁定资金)
     *
     * @param total 账户总额(可用余额+锁定资金)
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * 获取可用余额
     *
     * @return available - 可用余额
     */
    public BigDecimal getAvailable() {
        return available;
    }

    /**
     * 设置可用余额
     *
     * @param available 可用余额
     */
    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    /**
     * 获取锁定资金
     *
     * @return locked - 锁定资金
     */
    public BigDecimal getLocked() {
        return locked;
    }

    /**
     * 设置锁定资金
     *
     * @param locked 锁定资金
     */
    public void setLocked(BigDecimal locked) {
        this.locked = locked;
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
        UserAccount other = (UserAccount) that;
        return (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()))
            && (this.getLocked() == null ? other.getLocked() == null : this.getLocked().equals(other.getLocked()))
            && (this.getLastupdate() == null ? other.getLastupdate() == null : this.getLastupdate().equals(other.getLastupdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        result = prime * result + ((getLocked() == null) ? 0 : getLocked().hashCode());
        result = prime * result + ((getLastupdate() == null) ? 0 : getLastupdate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userNo=").append(userNo);
        sb.append(", total=").append(total);
        sb.append(", available=").append(available);
        sb.append(", locked=").append(locked);
        sb.append(", lastupdate=").append(lastupdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}