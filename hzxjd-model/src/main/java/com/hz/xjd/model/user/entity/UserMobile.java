package com.hz.xjd.model.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_mobile")
public class UserMobile implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 内部用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 登录失败次数(未使用)
     */
    @Column(name = "failure_times")
    private Integer failureTimes;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "last_logintime")
    private Date lastLogintime;

    /**
     * 删除标示(0:未删除 1:删除)
     */
    @Column(name = "delete_flg")
    private Integer deleteFlg;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取内部用户编号
     *
     * @return user_no - 内部用户编号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置内部用户编号
     *
     * @param userNo 内部用户编号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取登录失败次数(未使用)
     *
     * @return failure_times - 登录失败次数(未使用)
     */
    public Integer getFailureTimes() {
        return failureTimes;
    }

    /**
     * 设置登录失败次数(未使用)
     *
     * @param failureTimes 登录失败次数(未使用)
     */
    public void setFailureTimes(Integer failureTimes) {
        this.failureTimes = failureTimes;
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
     * 获取最后登录时间
     *
     * @return last_logintime - 最后登录时间
     */
    public Date getLastLogintime() {
        return lastLogintime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLogintime 最后登录时间
     */
    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
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
        UserMobile other = (UserMobile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getFailureTimes() == null ? other.getFailureTimes() == null : this.getFailureTimes().equals(other.getFailureTimes()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastLogintime() == null ? other.getLastLogintime() == null : this.getLastLogintime().equals(other.getLastLogintime()))
            && (this.getDeleteFlg() == null ? other.getDeleteFlg() == null : this.getDeleteFlg().equals(other.getDeleteFlg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getFailureTimes() == null) ? 0 : getFailureTimes().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastLogintime() == null) ? 0 : getLastLogintime().hashCode());
        result = prime * result + ((getDeleteFlg() == null) ? 0 : getDeleteFlg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", mobile=").append(mobile);
        sb.append(", password=").append(password);
        sb.append(", userNo=").append(userNo);
        sb.append(", failureTimes=").append(failureTimes);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastLogintime=").append(lastLogintime);
        sb.append(", deleteFlg=").append(deleteFlg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}