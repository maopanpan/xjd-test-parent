package com.hz.xjd.model.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User implements Serializable {
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
     * 三方帐号(富友)
     */
    @Column(name = "account_fy")
    private String accountFy;

    /**
     * 三方帐号(托管)
     */
    @Column(name = "account_trust")
    private String accountTrust;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 推荐人的邀请码
     */
    @Column(name = "invite_code")
    private String inviteCode;

    /**
     * 用户邀请码(唯一)
     */
    private String reffer;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 证件类型(身份证)
     */
    private String idtype;

    /**
     * 证件编号(身份证号)
     */
    private String idcard;

    /**
     * 用户来源：苹果端注册、安卓端注册、其他
     */
    @Column(name = "source_from")
    private String sourceFrom;

    /**
     * 性别
     */
    private String sex;

    /**
     * 大陆人士，港澳人士，台胞人士，外籍人士
     */
    @Column(name = "register_type")
    private String registerType;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 注册时间(手机表中的创建时间)
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 是否可用
     */
    @Column(name = "is_enable")
    private String isEnable;

    /**
     * 是否黑名单
     */
    @Column(name = "is_blacklist")
    private String isBlacklist;

    /**
     * 是否锁定
     */
    @Column(name = "is_locked")
    private String isLocked;

    /**
     * 是否内部员工
     */
    @Column(name = "is_employee")
    private String isEmployee;

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
     * 获取三方帐号(富友)
     *
     * @return account_fy - 三方帐号(富友)
     */
    public String getAccountFy() {
        return accountFy;
    }

    /**
     * 设置三方帐号(富友)
     *
     * @param accountFy 三方帐号(富友)
     */
    public void setAccountFy(String accountFy) {
        this.accountFy = accountFy == null ? null : accountFy.trim();
    }

    /**
     * 获取三方帐号(托管)
     *
     * @return account_trust - 三方帐号(托管)
     */
    public String getAccountTrust() {
        return accountTrust;
    }

    /**
     * 设置三方帐号(托管)
     *
     * @param accountTrust 三方帐号(托管)
     */
    public void setAccountTrust(String accountTrust) {
        this.accountTrust = accountTrust == null ? null : accountTrust.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取推荐人的邀请码
     *
     * @return invite_code - 推荐人的邀请码
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * 设置推荐人的邀请码
     *
     * @param inviteCode 推荐人的邀请码
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    /**
     * 获取用户邀请码(唯一)
     *
     * @return reffer - 用户邀请码(唯一)
     */
    public String getReffer() {
        return reffer;
    }

    /**
     * 设置用户邀请码(唯一)
     *
     * @param reffer 用户邀请码(唯一)
     */
    public void setReffer(String reffer) {
        this.reffer = reffer == null ? null : reffer.trim();
    }

    /**
     * 获取邮箱地址
     *
     * @return email - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取证件类型(身份证)
     *
     * @return idtype - 证件类型(身份证)
     */
    public String getIdtype() {
        return idtype;
    }

    /**
     * 设置证件类型(身份证)
     *
     * @param idtype 证件类型(身份证)
     */
    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    /**
     * 获取证件编号(身份证号)
     *
     * @return idcard - 证件编号(身份证号)
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置证件编号(身份证号)
     *
     * @param idcard 证件编号(身份证号)
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取用户来源：苹果端注册、安卓端注册、其他
     *
     * @return source_from - 用户来源：苹果端注册、安卓端注册、其他
     */
    public String getSourceFrom() {
        return sourceFrom;
    }

    /**
     * 设置用户来源：苹果端注册、安卓端注册、其他
     *
     * @param sourceFrom 用户来源：苹果端注册、安卓端注册、其他
     */
    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom == null ? null : sourceFrom.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取大陆人士，港澳人士，台胞人士，外籍人士
     *
     * @return register_type - 大陆人士，港澳人士，台胞人士，外籍人士
     */
    public String getRegisterType() {
        return registerType;
    }

    /**
     * 设置大陆人士，港澳人士，台胞人士，外籍人士
     *
     * @param registerType 大陆人士，港澳人士，台胞人士，外籍人士
     */
    public void setRegisterType(String registerType) {
        this.registerType = registerType == null ? null : registerType.trim();
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取注册时间(手机表中的创建时间)
     *
     * @return register_time - 注册时间(手机表中的创建时间)
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间(手机表中的创建时间)
     *
     * @param registerTime 注册时间(手机表中的创建时间)
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取是否可用
     *
     * @return is_enable - 是否可用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否可用
     *
     * @param isEnable 是否可用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    /**
     * 获取是否黑名单
     *
     * @return is_blacklist - 是否黑名单
     */
    public String getIsBlacklist() {
        return isBlacklist;
    }

    /**
     * 设置是否黑名单
     *
     * @param isBlacklist 是否黑名单
     */
    public void setIsBlacklist(String isBlacklist) {
        this.isBlacklist = isBlacklist == null ? null : isBlacklist.trim();
    }

    /**
     * 获取是否锁定
     *
     * @return is_locked - 是否锁定
     */
    public String getIsLocked() {
        return isLocked;
    }

    /**
     * 设置是否锁定
     *
     * @param isLocked 是否锁定
     */
    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked == null ? null : isLocked.trim();
    }

    /**
     * 获取是否内部员工
     *
     * @return is_employee - 是否内部员工
     */
    public String getIsEmployee() {
        return isEmployee;
    }

    /**
     * 设置是否内部员工
     *
     * @param isEmployee 是否内部员工
     */
    public void setIsEmployee(String isEmployee) {
        this.isEmployee = isEmployee == null ? null : isEmployee.trim();
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getAccountFy() == null ? other.getAccountFy() == null : this.getAccountFy().equals(other.getAccountFy()))
            && (this.getAccountTrust() == null ? other.getAccountTrust() == null : this.getAccountTrust().equals(other.getAccountTrust()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
            && (this.getReffer() == null ? other.getReffer() == null : this.getReffer().equals(other.getReffer()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getIdtype() == null ? other.getIdtype() == null : this.getIdtype().equals(other.getIdtype()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getSourceFrom() == null ? other.getSourceFrom() == null : this.getSourceFrom().equals(other.getSourceFrom()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getRegisterType() == null ? other.getRegisterType() == null : this.getRegisterType().equals(other.getRegisterType()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
            && (this.getIsBlacklist() == null ? other.getIsBlacklist() == null : this.getIsBlacklist().equals(other.getIsBlacklist()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getIsEmployee() == null ? other.getIsEmployee() == null : this.getIsEmployee().equals(other.getIsEmployee()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getAccountFy() == null) ? 0 : getAccountFy().hashCode());
        result = prime * result + ((getAccountTrust() == null) ? 0 : getAccountTrust().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getReffer() == null) ? 0 : getReffer().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIdtype() == null) ? 0 : getIdtype().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getSourceFrom() == null) ? 0 : getSourceFrom().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getRegisterType() == null) ? 0 : getRegisterType().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        result = prime * result + ((getIsBlacklist() == null) ? 0 : getIsBlacklist().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getIsEmployee() == null) ? 0 : getIsEmployee().hashCode());
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
        sb.append(", accountFy=").append(accountFy);
        sb.append(", accountTrust=").append(accountTrust);
        sb.append(", realName=").append(realName);
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", reffer=").append(reffer);
        sb.append(", email=").append(email);
        sb.append(", idtype=").append(idtype);
        sb.append(", idcard=").append(idcard);
        sb.append(", sourceFrom=").append(sourceFrom);
        sb.append(", sex=").append(sex);
        sb.append(", registerType=").append(registerType);
        sb.append(", userType=").append(userType);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", isBlacklist=").append(isBlacklist);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", isEmployee=").append(isEmployee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}