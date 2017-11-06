package com.hz.xjd.model.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_transaction")
public class UserTransaction implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户编号(内部用)
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 交易引用的编号
     */
    @Column(name = "ref_no")
    private String refNo;

    /**
     * 交易类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 进帐金额
     */
    @Column(name = "amount_in")
    private BigDecimal amountIn;

    /**
     * 出帐金额
     */
    @Column(name = "amount_out")
    private BigDecimal amountOut;

    /**
     * 发生时间
     */
    @Column(name = "occur_time")
    private Date occurTime;

    /**
     * 本笔交易之后的帐户余额
     */
    private BigDecimal balance;

    /**
     * 备注
     */
    private String memo;

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
     * 获取交易引用的编号
     *
     * @return ref_no - 交易引用的编号
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * 设置交易引用的编号
     *
     * @param refNo 交易引用的编号
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo == null ? null : refNo.trim();
    }

    /**
     * 获取交易类型
     *
     * @return trans_type - 交易类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 设置交易类型
     *
     * @param transType 交易类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * 获取进帐金额
     *
     * @return amount_in - 进帐金额
     */
    public BigDecimal getAmountIn() {
        return amountIn;
    }

    /**
     * 设置进帐金额
     *
     * @param amountIn 进帐金额
     */
    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    /**
     * 获取出帐金额
     *
     * @return amount_out - 出帐金额
     */
    public BigDecimal getAmountOut() {
        return amountOut;
    }

    /**
     * 设置出帐金额
     *
     * @param amountOut 出帐金额
     */
    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    /**
     * 获取发生时间
     *
     * @return occur_time - 发生时间
     */
    public Date getOccurTime() {
        return occurTime;
    }

    /**
     * 设置发生时间
     *
     * @param occurTime 发生时间
     */
    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    /**
     * 获取本笔交易之后的帐户余额
     *
     * @return balance - 本笔交易之后的帐户余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置本笔交易之后的帐户余额
     *
     * @param balance 本笔交易之后的帐户余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        UserTransaction other = (UserTransaction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getRefNo() == null ? other.getRefNo() == null : this.getRefNo().equals(other.getRefNo()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getAmountIn() == null ? other.getAmountIn() == null : this.getAmountIn().equals(other.getAmountIn()))
            && (this.getAmountOut() == null ? other.getAmountOut() == null : this.getAmountOut().equals(other.getAmountOut()))
            && (this.getOccurTime() == null ? other.getOccurTime() == null : this.getOccurTime().equals(other.getOccurTime()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getRefNo() == null) ? 0 : getRefNo().hashCode());
        result = prime * result + ((getTransType() == null) ? 0 : getTransType().hashCode());
        result = prime * result + ((getAmountIn() == null) ? 0 : getAmountIn().hashCode());
        result = prime * result + ((getAmountOut() == null) ? 0 : getAmountOut().hashCode());
        result = prime * result + ((getOccurTime() == null) ? 0 : getOccurTime().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
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
        sb.append(", refNo=").append(refNo);
        sb.append(", transType=").append(transType);
        sb.append(", amountIn=").append(amountIn);
        sb.append(", amountOut=").append(amountOut);
        sb.append(", occurTime=").append(occurTime);
        sb.append(", balance=").append(balance);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}